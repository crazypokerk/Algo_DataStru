package com.exe.wenda.util;

import com.sun.org.apache.regexp.internal.RE;

/**
 * @Date 2019/4/11 15:23
 */
/*
    专门用来生成Redis的key，保证key不重复，并且不同的业务加不同的前缀。
 */
public class RedisKeyUtil {
    private static String SPLIT = ":";
    //点赞
    private static String BIZ_LIKE = "LIKE";
    //取消喜欢
    private static String BIZ_DISLIKE = "DISLIKE";
    //事件队列
    private static String BIZ_EVENTQUEUE = "EVENT_QUEUE";
    // 获取粉丝
    private static String BIZ_FOLLOWER = "FOLLOWER";
    // 关注对象
    private static String BIZ_FOLLOWEE = "FOLLOWEE";

    private static String BIZ_TIMELINE = "TIMELINE";

    public static String getLikeKey(int entityType, int entityId) {
        return BIZ_LIKE + SPLIT + String.valueOf(entityType) + SPLIT + String.valueOf(entityId);
    }

    public static String getDisLikeKey(int entityType, int entityId) {
        return BIZ_DISLIKE + SPLIT + String.valueOf(entityType) + SPLIT + String.valueOf(entityId);
    }

    public static String getEventQueueKey() {
        return BIZ_EVENTQUEUE;
    }

    //粉丝的get方法
    public static String getFollowerKey(int entityType, int entityId) {
        return BIZ_FOLLOWER + SPLIT + String.valueOf(entityType) + SPLIT + String.valueOf(entityId);
    }

    //关注对象的get方法
    public static String getFolloweeKey(int userId, int entityType) {
        return BIZ_FOLLOWEE + SPLIT + String.valueOf(userId) + SPLIT + String.valueOf(entityType);
    }

    public static String getTimeLineKey(int entityType, int entityId) {
        return BIZ_TIMELINE + SPLIT + String.valueOf(entityType) + SPLIT + String.valueOf(entityId);
    }

    //timeline的key生成
    public static String getTimelineKey(int userId) {
        return BIZ_TIMELINE + SPLIT + String.valueOf(userId);
    }
}
