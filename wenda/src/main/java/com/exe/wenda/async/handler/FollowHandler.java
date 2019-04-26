package com.exe.wenda.async.handler;

import com.exe.wenda.async.EventHandler;
import com.exe.wenda.async.EventModel;
import com.exe.wenda.async.EventType;
import com.exe.wenda.model.EntityType;
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
 * @Date 2019/4/13 13:38
 */
/*
    关注问题或者关注人，发送站内信功能
 */
@Component
public class FollowHandler implements EventHandler {
    @Autowired
    MessageService messageService;

    @Autowired
    UserService userService;

    @Override
    public void doHandle(EventModel model) {
        //定义一个消息
        Message message = new Message();
        //系统发送
        message.setFromId(WendaUtil.SYSTEM_USERID);
        message.setToId(model.getEntityOwnerId());
        message.setCreatedDate(new Date());
        User user = userService.getUser(model.getActorId());

        //如果关注的是问题
        if (model.getEntityType() == EntityType.ENTITY_QUESTION) {
            message.setContent("用户" + user.getName()
                    + "关注了你的问题,http://127.0.0.1:8080/question/" + model.getEntityId());
        } else if (model.getEntityType() == EntityType.ENTITY_USER) {//如果关注的是人
            message.setContent("用户" + user.getName()
                    + "关注了你,http://127.0.0.1:8080/user/" + model.getActorId());
        }

        messageService.addMessage(message);
    }

    @Override
    public List<EventType> getSupportEventTypes() {
        return Arrays.asList(EventType.FOLLOW);
    }
}
