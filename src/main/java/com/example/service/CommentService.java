package com.example.service;

import com.example.entity.Comment;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 关注公众号：example
 * @since 2023-01-24
 */
public interface CommentService extends IService<Comment> {
    /**
     * 保存用户的评论 一级评论
     * @param comment
     * @return
     */
    void saveUserComment(Comment comment);

    /**
     * 根据文章id获取评论和回复
     * @return
     */
    List<Comment> queryCommentReply(long articleId);
}
