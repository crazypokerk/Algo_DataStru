package com.exe.wenda.model;

import com.alibaba.fastjson.JSONObject;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @Date 2019/4/15 9:56
 */
/*
    新鲜事feed流model
 */
public class Feed {
    @Setter(value = AccessLevel.PUBLIC)
    @Getter(value = AccessLevel.PUBLIC)
    private int id;

    //新鲜事不同的类型
    @Setter(value = AccessLevel.PUBLIC)
    @Getter(value = AccessLevel.PUBLIC)
    private int type;

    //由哪一个人产生的新鲜事
    @Setter(value = AccessLevel.PUBLIC)
    @Getter(value = AccessLevel.PUBLIC)
    private int userId;

    //产生事件
    @Setter(value = AccessLevel.PUBLIC)
    @Getter(value = AccessLevel.PUBLIC)
    private Date createdDate;

    //新鲜事数据，用JSON格式存储
    @Getter(value = AccessLevel.PUBLIC)
    private String data;

    //辅助遍历
    private JSONObject dataJSON = null;

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
