package com.exe.wenda.model;

import com.alibaba.fastjson.JSONObject;

import java.util.Date;

/**
 * @Date 2019/4/15 9:56
 */
/*
    新鲜事feed流model
 */
public class Feed {
    private int id;
    //新鲜事不同的类型
    private int type;
    //由哪一个人产生的新鲜事
    private int userId;
    //产生事件
    private Date createdDate;
    //新鲜事数据，用JSON格式存储
    private String data;

    //辅助遍历
    private JSONObject dataJSON = null;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
        //初始化
        dataJSON = JSONObject.parseObject(data);
    }

    //help方法
    public String get(String key) {
        return dataJSON == null ? null : dataJSON.getString(key);
    }
}
