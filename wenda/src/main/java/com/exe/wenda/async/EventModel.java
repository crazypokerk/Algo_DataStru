package com.exe.wenda.async;

import java.util.HashMap;
import java.util.Map;

/**
 * @Date 2019/4/12 10:39
 */
/*
    该类是要生产的事件，有客户端发起事件，则对应一个事件实体，存储事件的信息。
    比如点赞、站内信、评论、邮件
 */
public class EventModel {
    //当时事件发生事件类型  点赞
    private EventType type;
    //触发该事件的触发者   谁点了赞
    private int actorId;
    //触发者触发了什么
    private int entityType;
    //触发者触发的对象的ID  给谁点了赞
    private int entityId;
    //被触发的对象和某人相关的ID
    private int entityOwnerId;
    //扩展的字段
    private Map<String, String> exts = new HashMap<String, String>();

    //retrun this 是为了方便后面链式编程，可以一直点调用方法

    //扩展字段可能只有一两个，那么就自己写一个set、get方法，不用外界再传入一个Map
    public EventModel setExt(String key, String value) {
        exts.put(key, value);
        return this;
    }

    public String getExt(String key) {
        return exts.get(key);
    }

    //构造函数
    public EventModel() {

    }

    public EventModel(EventType type) {
        this.type = type;
    }


    public EventType getType() {
        return type;
    }

    public EventModel setType(EventType type) {
        this.type = type;
        return this;
    }

    public int getActorId() {
        return actorId;
    }

    public EventModel setActorId(int actorId) {
        this.actorId = actorId;
        return this;
    }

    public int getEntityType() {
        return entityType;
    }

    public EventModel setEntityType(int entityType) {
        this.entityType = entityType;
        return this;
    }

    public int getEntityId() {
        return entityId;
    }

    public EventModel setEntityId(int entityId) {
        this.entityId = entityId;
        return this;
    }

    public int getEntityOwnerId() {
        return entityOwnerId;
    }

    public EventModel setEntityOwnerId(int entityOwnerId) {
        this.entityOwnerId = entityOwnerId;
        return this;
    }

    public Map<String, String> getExts() {
        return exts;
    }

    public EventModel setExts(Map<String, String> exts) {
        this.exts = exts;
        return this;
    }
}
