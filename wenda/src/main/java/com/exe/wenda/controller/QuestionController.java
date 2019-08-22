package com.exe.wenda.controller;

import com.exe.wenda.async.EventModel;
import com.exe.wenda.async.EventProducer;
import com.exe.wenda.async.EventType;
import com.exe.wenda.model.*;
import com.exe.wenda.service.*;
import com.exe.wenda.util.WendaUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Date 2019/4/4 15:09
 */
/*
    提问功能
 */
@Controller
public class QuestionController {
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    QuestionService questionService;

    @Autowired
    CommentService commentService;

    @Autowired
    HostHolder hostHolder;

    @Autowired
    UserService userService;

    @Autowired
    LikeService likeService;
    @Autowired
    FollowService followService;

    @Autowired
    EventProducer eventProducer;

    //问题详情
    @RequestMapping(value = "/question/{qid}", method = {RequestMethod.GET})
    public String questionDetail(Model model, @PathVariable("qid") int qid) {
        //把问题查出来
        Question question = questionService.getById(qid);
        model.addAttribute("question", question);

        List<Comment> commentList = commentService.getCommentsByEntity(qid, EntityType.ENTITY_QUESTION);
        //一个评论单元里面 包含的所有内容
        List<ViewObject> comments = new ArrayList<ViewObject>();
        for (Comment comment : commentList) {
            ViewObject vo = new ViewObject();
            vo.setObject("comment", comment);
            if (hostHolder.getUser() == null) {
                vo.setObject("liked", 0);
            } else {
                vo.setObject("liked", likeService.getLikeStatus(hostHolder.getUser().getId(), EntityType.ENTITY_COMMENT, comment.getId()));
            }

            //点赞数量
            vo.setObject("likeCount", likeService.getLikeCount(EntityType.ENTITY_COMMENT, comment.getId()));
            //点赞人
            vo.setObject("user", userService.getUser(comment.getUserId()));
            comments.add(vo);
        }

        model.addAttribute("comments", comments);

        List<ViewObject> followUsers = new ArrayList<ViewObject>();
        // 获取关注的用户信息
        List<Integer> users = followService.getFollowers(EntityType.ENTITY_QUESTION, qid, 20);
        for (Integer userId : users) {
            ViewObject vo = new ViewObject();
            User u = userService.getUser(userId);
            if (u == null) {
                continue;
            }
            vo.setObject("name", u.getName());
            vo.setObject("headUrl", u.getHeadUrl());
            vo.setObject("id", u.getId());
            followUsers.add(vo);
        }
        model.addAttribute("followUsers", followUsers);
        if (hostHolder.getUser() != null) {
            model.addAttribute("followed", followService.isFollower(hostHolder.getUser().getId(), EntityType.ENTITY_QUESTION, qid));
        } else {
            model.addAttribute("followed", false);
        }

        return "detail";
    }

    @RequestMapping(value = "/question/add", method = {RequestMethod.POST})
    /**
     * 表示该方法的返回结果直接写入 HTTP response body 中，一般在
     * 异步获取数据时使用【也就是AJAX】，在使用 @RequestMapping后，
     * 返回值通常解析为跳转路径，但是加上 @ResponseBody 后返回结果
     * 不会被解析为跳转路径，而是直接写入 HTTP response body 中。
     * 比如异步获取 json 数据，加上 @ResponseBody 后，会直接返回 json 数据。
     */
    @ResponseBody
    //添加问题  标题，内容
    public String addQuestion(@RequestParam("title") String title, @RequestParam("content") String content) {
        try {
            Question question = new Question();
            //设置问题信息
            question.setContent(content);
            question.setCreatedDate(new Date());
            question.setTitle(title);

            //如果未登录，给一个匿名用户
            if (hostHolder.getUser() == null) {
                question.setUserId(WendaUtil.ANONYMOUS_USERID);
                // return WendaUtil.getJSONString(999);
            } else {
                question.setUserId(hostHolder.getUser().getId());
            }
            //增加成功，返回0
            if (questionService.addQuestion(question) > 0) {
                eventProducer.fireEvent(new EventModel(EventType.ADD_QUESTION)
                        .setActorId(question.getUserId()).setEntityId(question.getId())
                        .setExt("title", question.getTitle()).setExt("content", question.getContent()));
                return WendaUtil.getJSONString(0);
            }
        } catch (Exception e) {
            logger.error("增加题目失败" + e.getMessage());
        }
        return WendaUtil.getJSONString(1, "失败");
    }
}
