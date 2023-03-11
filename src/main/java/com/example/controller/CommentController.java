package com.example.controller;


import com.example.common.lang.Result;
import com.example.entity.Comment;
import com.example.entity.Reply;
import com.example.entity.User;
import com.example.service.CommentService;
import com.example.service.ReplyService;
import com.example.service.UserService;
import com.example.vo.CommentReplyVO;
import com.example.vo.ReplyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 关注公众号：example
 * @since 2023-01-24
 */
@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    CommentService commentService;
    @Autowired
    UserService userService;
    @Autowired
    ReplyService replyService;
    /**
     * "保存用户的评论(一级评论)"
      */
    @PutMapping("/saveUserComment")
    public Result userComment(@RequestBody Comment commentParam){
        try {
            commentService.saveUserComment(commentParam);
            return Result.succ("发表评论成功");
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail("发表评论失败");
        }


    }

    /**
     * 通过文章ID获取评论和回复
     */

    @PostMapping("getCommentReply/{articleId}")
    public Result getCommentReply(@PathVariable("articleId") long articleId){

        List<Comment> commentList =  commentService.queryCommentReply(articleId);

        List<CommentReplyVO> commentReplyVOList = new ArrayList<CommentReplyVO>();

        if(!commentList.isEmpty()){
            for(int i=0; i < commentList.size();i++){
                CommentReplyVO commentReplyVO = new CommentReplyVO();
                Comment comment = commentList.get(i);
                long commentId = comment.getCommentId();
                commentReplyVO.setCommentId(commentId);
                commentReplyVO.setCommentTime(comment.getCommentTime());
                commentReplyVO.setCommentContent(comment.getCommentContent());
                commentReplyVO.setInputShow(false);
                //得到回复用户的id，通过id查询用户信息
                long userId = comment.getCommentUserId();
                User userVO = userService.queryUserinfoById(userId);
                commentReplyVO.setUserId(userId);
                commentReplyVO.setPortrait(userVO.getPortrait());
                commentReplyVO.setNickname(userVO.getNickname());
                //通过回复的Id去获取回复内容
                List<ReplyVO> replyList = replyService.queryReplyByCommentId(commentId);
                commentReplyVO.setReply(replyList);
                commentReplyVOList.add(commentReplyVO);
            }

        }


        return Result.succ(commentReplyVOList);

    }



}
