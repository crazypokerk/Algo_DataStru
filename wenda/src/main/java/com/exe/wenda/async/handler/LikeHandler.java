package com.exe.wenda.async.handler;

import com.exe.wenda.async.EventHandler;
import com.exe.wenda.async.EventModel;
import com.exe.wenda.async.EventType;
import com.exe.wenda.model.Message;
import com.exe.wenda.model.User;
import com.exe.wenda.service.MessageService;
import com.exe.wenda.service.UserService;
import com.exe.wenda.util.WendaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @Date 2019/4/12 13:11
 */
/*
    EventHandler的实现类，负责处理点赞并发送站内信通知
 */
@Component
public class LikeHandler implements EventHandler {
    @Autowired
    MessageService messageService;

    @Autowired
    UserService userService;

    @Override
    public void doHandle(EventModel model) {
        //创建新消息对象
        Message message = new Message();
        //管理员发送消息
        message.setFromId(WendaUtil.SYSTEM_USERID);
        //被点赞人接收消息
        message.setToId(model.getEntityOwnerId());
        //设置当前时间
        message.setCreatedDate(new Date());
        //取得事件触发用户的ID
        User user = userService.getUser(model.getActorId());
        message.setContent("用户" + user.getName()
                + "赞了你的评论,http://127.0.0.1:8080/question/" + model.getExt("questionId"));

        messageService.addMessage(message);
    }

    @Override
    public List<EventType> getSupportEventTypes() {
        //LikeHandler只关心LIKE事件
        return Arrays.asList(EventType.LIKE);
    }
}
