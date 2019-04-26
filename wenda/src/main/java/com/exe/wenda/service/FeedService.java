package com.exe.wenda.service;

import com.exe.wenda.dao.FeedDAO;
import com.exe.wenda.model.Feed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Date 2019/4/15 10:02
 */
/*
    用来读取feed流
 */
@Service
public class FeedService {
    @Autowired
    FeedDAO feedDAO;

    //拉模式
    public List<Feed> getUserFeeds(int maxId, List<Integer> userIds, int count) {
        return feedDAO.selectUserFeeds(maxId, userIds, count);
    }

    //增加一个feed
    public boolean addFeed(Feed feed) {
        feedDAO.addFeed(feed);
        return feed.getId() > 0;
    }

    //推模式
    public Feed getById(int id) {
        return feedDAO.getFeedById(id);
    }
}
