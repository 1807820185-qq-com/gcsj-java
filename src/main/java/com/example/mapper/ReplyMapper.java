package com.example.mapper;

import com.example.entity.Reply;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.vo.ReplyVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 关注公众号：example
 * @since 2023-01-24
 */
public interface ReplyMapper extends BaseMapper<Reply> {

    List<ReplyVO>  queryReplyByCommentId(@Param("commentId")long commentId);

}
