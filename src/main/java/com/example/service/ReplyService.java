package com.example.service;

import com.example.entity.Reply;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.vo.ReplyVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 关注公众号：example
 * @since 2023-01-24
 */
public interface ReplyService extends IService<Reply> {
    /**
     * 保存用户的品论
     * @param replyParam
     * @return
     */
    void saveUserReply(Reply reply);

    List<ReplyVO> queryReplyByCommentId(long commentId);
}
