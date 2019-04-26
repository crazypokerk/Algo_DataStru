package com.exe.wenda.service;

import com.exe.wenda.util.JedisAdapter;
import com.exe.wenda.util.RedisKeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @Date 2019/4/13 11:22
 */
/*
    关注功能
 */
@Service
public class FollowService {
    //所有的关注放在Redis里面
    @Autowired
    JedisAdapter jedisAdapter;

    //关注功能
    public boolean follow(int userId, int entityType, int entityId) {
        //粉丝key
        String followerKey = RedisKeyUtil.getFollowerKey(entityType, entityId);
        //关注对象key
        String followeeKey = RedisKeyUtil.getFolloweeKey(userId, entityType);
        //关注时间
        Date date = new Date();
        //获取一个Jedis
        Jedis jedis = jedisAdapter.getJedis();
        //获取一个Transaction
        Transaction tx = jedisAdapter.multi(jedis);
        //事务
        /*
        事务保证要么都成功，要么就失败，即关注成功，粉丝加1，关注者也加1
         */
        tx.zadd(followerKey, date.getTime(), String.valueOf(userId));
        tx.zadd(followeeKey, date.getTime(), String.valueOf(entityId));
        //执行事务
        List<Object> ret = jedisAdapter.exec(tx, jedis);
        //执行成功的话，List里面粉丝数和关注对象数都肯定大于0
        return ret.size() == 2 && (Long) ret.get(0) > 0 && (Long) ret.get(1) > 0;
    }

    //取消关注功能
    public boolean unFollow(int userId, int entityType, int entityId) {
        //粉丝key
        String followerKey = RedisKeyUtil.getFollowerKey(entityType, entityId);
        //关注对象key
        String followeeKey = RedisKeyUtil.getFolloweeKey(userId, entityType);
        //关注时间
        Date date = new Date();
        //获取一个Jedis
        Jedis jedis = jedisAdapter.getJedis();
        //获取一个Transaction
        Transaction tx = jedisAdapter.multi(jedis);
        //事务
        tx.zrem(followerKey, String.valueOf(userId));
        tx.zrem(followeeKey, String.valueOf(entityId));
        //执行事务
        List<Object> ret = jedisAdapter.exec(tx, jedis);
        //执行成功的话，List里面粉丝数和关注对象数都肯定大于0
        return ret.size() == 2 && (Long) ret.get(0) > 0 && (Long) ret.get(1) > 0;
    }

    //help函数，功能是把Set中的String转成List的Integer
    private List<Integer> getIdFromSet(Set<String> idset) {
        List<Integer> ids = new ArrayList<>();
        for (String str :
                idset) {
            ids.add(Integer.parseInt(str));
        }
        return ids;
    }

    //获取所有的粉丝功能，取反向的，也就是去最新关注的
    public List<Integer> getFollowers(int entityType, int entityId, int count) {
        String follwerKey = RedisKeyUtil.getFollowerKey(entityType, entityId);
        return getIdFromSet(jedisAdapter.zrevrange(follwerKey, 0, count));
    }

    //获取所有的粉丝，可分页
    public List<Integer> getFollowers(int entityType, int entityId, int offset, int count) {
        String follwerKey = RedisKeyUtil.getFollowerKey(entityType, entityId);
        return getIdFromSet(jedisAdapter.zrevrange(follwerKey, offset, count));
    }

    //获取所有的关注者
    public List<Integer> getFollowees(int entityType, int entityId, int count) {
        String follweeKey = RedisKeyUtil.getFolloweeKey(entityType, entityId);
        return getIdFromSet(jedisAdapter.zrevrange(follweeKey, 0, count));
    }

    //获取所有的关注者，可分页
    public List<Integer> getFollowees(int entityType, int entityId, int offset, int count) {
        String follweeKey = RedisKeyUtil.getFolloweeKey(entityType, entityId);
        return getIdFromSet(jedisAdapter.zrevrange(follweeKey, offset, count));
    }

    //实体里有多少粉丝数
    public long getFollowerCount(int entityType, int entityId) {
        String follwerKey = RedisKeyUtil.getFollowerKey(entityType, entityId);
        return jedisAdapter.zcard(follwerKey);
    }

    //实体有多少关注者数
    public long getFolloweeCount(int entityType, int entityId) {
        String follweeKey = RedisKeyUtil.getFolloweeKey(entityType, entityId);
        return jedisAdapter.zcard(follweeKey);
    }

    //判断有没有关注
    public boolean isFollower(int userId, int entityType, int entityId) {
        String followerKey = RedisKeyUtil.getFollowerKey(entityType, entityId);
        return jedisAdapter.zscore(followerKey, String.valueOf(userId)) != null;
    }

}
