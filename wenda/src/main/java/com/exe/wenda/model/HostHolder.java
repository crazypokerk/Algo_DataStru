package com.exe.wenda.model;

import org.springframework.stereotype.Component;

@Component
//专门放取出来的用户
public class HostHolder {
    //线程本地变量，每个线程独有一份
    private static ThreadLocal<User> users = new ThreadLocal<User>();

    public User getUser() {
        return users.get();
    }

    public void setUser(User user) {
        users.set(user);
    }

    public void clear() {
        users.remove();
    }
}
