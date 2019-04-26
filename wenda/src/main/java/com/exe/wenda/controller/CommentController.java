package com.exe.wenda.controller;

import com.exe.wenda.async.EventModel;
import com.exe.wenda.async.EventProducer;
import com.exe.wenda.async.EventType;
import com.exe.wenda.model.Comment;
import com.exe.wenda.model.EntityType;
import com.exe.wenda.model.HostHolder;
import com.exe.wenda.service.CommentService;
import com.exe.wenda.service.QuestionService;
import com.exe.wenda.service.SensitiveService;
import com.exe.wenda.service.UserService;
import com.exe.wenda.util.WendaUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.HtmlUtils;

import java.util.Date;

/**
 * @Date 2019/4/6 16:12
 */
@Controller
public class CommentController {
    private static final Logger logger = LoggerFactory.getLogger(CommentController.class);
    @Autowired
    HostHolder hostHolder;

    @Autowired
    UserService userService;

    @Autowired
    CommentService commentService;

    @Autowired
    QuestionService questionService;

    @Autowired
    SensitiveService sensitiveService;

    @Autowired
    EventProducer eventProducer;

    //增加评论
    @RequestMapping(path = {"/addComment"}, method = {RequestMethod.POST})
    public String addComment(@RequestParam("questionId") int questionId,
                             @RequestParam("content") String content) {
        try {
            //过滤content
            content = HtmlUtils.htmlEscape(content);
            content = sensitiveService.filter(content);
            Comment comment = new Comment();
            //判断用户是否登录
            if (hostHolder.getUser() != null) {
                comment.setUserId(hostHolder.getUser().getId());
            } else {
                //可以让重新登录，也可以用匿名用户
                //return "redirect:/reglogin";
                comment.setUserId(WendaUtil.ANONYMOUS_USERID);
            }
            //设置评论信息
            comment.setContent(content);
            comment.setEntityId(questionId);
            comment.setEntityType(EntityType.ENTITY_QUESTION);
            comment.setCreatedDate(new Date());
            comment.setStatus(0);

            commentService.addComment(comment);
            // 更新题目里的评论数量
            int count = commentService.getCommentCount(comment.getEntityId(), comment.getEntityType());
            questionService.updateCommentCount(comment.getEntityId(), count);

            eventProducer.fireEvent(new EventModel(EventType.COMMENT).setActorId(comment.getUserId())
                    .setEntityId(questionId));

        } catch (Exception e) {
            logger.error("增加评论失败" + e.getMessage());
        }
        return "redirect:/question/" + questionId;
    }
}
