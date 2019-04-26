package com.exe.wenda.service;

import com.exe.wenda.dao.LoginTicketDAO;
import com.exe.wenda.dao.UserDAO;
import com.exe.wenda.model.LoginTicket;
import com.exe.wenda.model.User;
import com.exe.wenda.util.WendaUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @Date 2019/3/26 16:05
 */
@Service
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private UserDAO userDAO;


    //用来读取ticket
    @Autowired
    private LoginTicketDAO loginTicketDAO;

    public User selectByName(String name) {
        return userDAO.selectByName(name);
    }

    //注册方法  （用户名，用户密码）
    public Map<String, Object> register(String username, String password) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (StringUtils.isBlank(username)) {
            map.put("msg", "用户名不能为空");
            return map;
        }

        if (StringUtils.isBlank(password)) {
            map.put("msg", "密码不能为空");
            return map;
        }

        User user = userDAO.selectByName(username);

        if (user != null) {
            map.put("msg", "用户名已经被注册");
            return map;
        }

        // 密码强度
        user = new User();
        user.setName(username);
        //用UUID随机生成一个盐
        user.setSalt(UUID.randomUUID().toString().substring(0, 5));
        //生成随机一个头像
        String head = String.format("http://images.nowcoder.com/head/%dt.png", new Random().nextInt(1000));
        user.setHeadUrl(head);
        //用原有密码+盐 用MD5加密
        user.setPassword(WendaUtil.MD5(password + user.getSalt()));
        userDAO.addUser(user);

        // 登陆
        String ticket = addLoginTicket(user.getId());
        //数据库中表 login_ticket
        map.put("ticket", ticket);
        return map;
    }


    public Map<String, Object> login(String username, String password) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (StringUtils.isBlank(username)) {
            map.put("msg", "用户名不能为空");
            return map;
        }

        if (StringUtils.isBlank(password)) {
            map.put("msg", "密码不能为空");
            return map;
        }

        User user = userDAO.selectByName(username);

        if (user == null) {
            map.put("msg", "用户名不存在");
            return map;
        }

        if (!WendaUtil.MD5(password + user.getSalt()).equals(user.getPassword())) {
            map.put("msg", "密码不正确");
            return map;
        }

        String ticket = addLoginTicket(user.getId());
        map.put("ticket", ticket);
        map.put("userId", user.getId());
        return map;
    }

    //用户要登录，增加一个ticket
    private String addLoginTicket(int userId) {
        LoginTicket ticket = new LoginTicket();
        ticket.setUserId(userId);
        Date date = new Date();
        //设置过期时间
        date.setTime(date.getTime() + 1000 * 3600 * 24);
        ticket.setExpired(date);
        ticket.setStatus(0);
        //随机生成一个ticket
        ticket.setTicket(UUID.randomUUID().toString().replaceAll("-", ""));
        loginTicketDAO.addTicket(ticket);
        return ticket.getTicket();
    }

    public User getUser(int id) {
        return userDAO.selectById(id);
    }

    public void logout(String ticket) {
        //1代表ticket无效了
        loginTicketDAO.updateStatus(ticket, 1);
    }
}
