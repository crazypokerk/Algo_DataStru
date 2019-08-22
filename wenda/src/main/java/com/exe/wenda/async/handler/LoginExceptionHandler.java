package com.exe.wenda.async.handler;

import com.exe.wenda.async.EventHandler;
import com.exe.wenda.async.EventModel;
import com.exe.wenda.async.EventType;
import com.exe.wenda.util.MailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Date 2019/4/13 10:19
 */
/*
    每次用户登录，给用户发送一个邮件提醒  既然是登录，就要在登录controller中
 */
@Component
public class LoginExceptionHandler implements EventHandler {
    @Autowired
    MailSender mailSender;

    public void doHandle(EventModel model) {
        //xxxx   判断该用户是否登录异常
        Map<String, Object> map = new HashMap<String, Object>();
        //传入username
        map.put("username", model.getExt("username"));
        mailSender.sendWithHTMLTemplate(model.getExt("email"), "登陆IP异常", "mails/login_exception.html", map);
    }

    public List<EventType> getSupportEventTypes() {
        return Arrays.asList(EventType.LOGIN);
    }
}
