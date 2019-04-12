package com.exe.wenda.async;

import com.alibaba.fastjson.JSONObject;
import com.exe.wenda.util.JedisAdapter;
import com.exe.wenda.util.RedisKeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Date 2019/4/12 12:42
 */
/*
    事件生产者，事件的入口，统一发送事件
 */
@Service
public class EventProducer {
    @Autowired
    JedisAdapter jedisAdapter;

    //把EventModel发出去
    public boolean fireEvent(EventModel eventModel) {
        try {
            String json = JSONObject.toJSONString(eventModel);
            String key = RedisKeyUtil.getEventQueueKey();
            jedisAdapter.lpush(key, json);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
