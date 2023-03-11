package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.entity.Comment;
import com.example.mapper.CommentMapper;
import com.example.service.CommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 关注公众号：example
 * @since 2023-01-24
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {
    @Autowired
    CommentMapper commentMapper;

    /**
     * 保存用户的评论 一级
     * @param comment
     * @return
     */
    @Override
    public void saveUserComment(Comment comment) {

        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String day = format.format(date);
        comment.setCommentTime(day);
        this.save(comment);
    }
    /**
     * 通过文章ID获取文章的评论
     * @param articleId
     * @return
     */
    @Override
    public List<Comment> queryCommentReply(long articleId) {

        LambdaQueryWrapper<Comment> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Comment::getCommentArticleId,articleId);
        lambdaQueryWrapper.orderByDesc(Comment::getCommentTime);

        return commentMapper.selectList(lambdaQueryWrapper);

    }
}
