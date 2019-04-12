package com.exe.wenda.async;


import com.alibaba.fastjson.JSON;
import com.exe.wenda.util.JedisAdapter;
import com.exe.wenda.util.RedisKeyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Date 2019/4/12 12:53
 */
/*
    事件消费者，事件的出口，统一接收事件，需要它把Event分发出去，
    它要把Event和handler之间的关系建立起来
 */
@Service
public class EventConsumer implements InitializingBean, ApplicationContextAware {
    private static final Logger logger = LoggerFactory.getLogger(EventConsumer.class);

    @Autowired
    JedisAdapter jedisAdapter;

    //当从队列里面取出一个Event的时候，看EventType是谁，找对处理该Event对应的那一批EventHandler
    private Map<EventType, List<EventHandler>> config = new HashMap<>();
    //SPRING上下文
    private ApplicationContext applicationContext;

    //在启动的时候就要初始化config
    @Override
    public void afterPropertiesSet() throws Exception {
        //找出所有EventHandler接口的实现类
        Map<String, EventHandler> beans = applicationContext.getBeansOfType(EventHandler.class);
        //如果还没有关联的Event和EventHandler
        if (beans != null) {
            //用Map的Entry类型，遍历beans里的Entry Set<Map.Entry<K, V>> entrySet();
            for (Map.Entry<String, EventHandler> entry : beans.entrySet()) {
                //找到这个EventHandler，并找出这个EventHandler关注哪些事件
                List<EventType> eventTypes = entry.getValue().getSupportEventTypes();
                //把这个EventHandler与关注的事件关联起来
                for (EventType type : eventTypes) {
                    if (!config.containsKey(type)) {
                        config.put(type, new ArrayList<EventHandler>());
                    }
                    config.get(type).add(entry.getValue());
                }
            }
        }
        /*
            可以使用线程池替换
         */
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    //从Redis中取信息
                    String key = RedisKeyUtil.getEventQueueKey();
                    //当队列里面没有元素时，就会阻塞
                    List<String> events = jedisAdapter.brpop(0, key);
                    //第一次取可能取到是BIZ_EVENTQUEUE，过滤掉
                    for (String message : events) {
                        if (message.equals(key)) {
                            continue;
                        }

                        //反序列化，通过JSON解析出来EventModel对象
                        EventModel eventModel = JSON.parseObject(message, EventModel.class);
                        if (!config.containsKey(eventModel.getType())) {
                            logger.error("不能识别的事件");
                            continue;
                        }

                        //处理EventModel
                        for (EventHandler handler : config.get(eventModel.getType())) {
                            handler.doHandle(eventModel);
                        }
                    }
                }
            }
        });
        thread.start();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
