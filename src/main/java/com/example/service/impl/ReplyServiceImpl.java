package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.entity.Reply;
import com.example.mapper.ReplyMapper;
import com.example.service.ReplyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.vo.ReplyVO;
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
public class ReplyServiceImpl extends ServiceImpl<ReplyMapper, Reply> implements ReplyService {
    @Autowired
    ReplyMapper replyMapper;
    /**
     * 保存用户的评论
     * @param reply
     * @return
     */
    @Override
    public void saveUserReply(Reply reply) {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String day = format.format(date);
        reply.setReplyTime(day);
        this.save(reply);
    }

    /**
     * 通过评论id查询回复
     * @param commentId
     * @return
     */
    @Override
    public List<ReplyVO> queryReplyByCommentId(long commentId) {
//        LambdaQueryWrapper<ReplyVO> lambdaQueryWrapper = new LambdaQueryWrapper<ReplyVO>();
//        lambdaQueryWrapper.eq(ReplyVO::getCommentId,commentId);
//        lambdaQueryWrapper.orderByDesc(ReplyVO::getReplyTime);


        List<ReplyVO> replyVOList=replyMapper.queryReplyByCommentId( commentId);
        return replyVOList;


//        return replyMapper.selectList(lambdaQueryWrapper);


    }
}
