package com.example.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author 关注公众号：example
 * @since 2023-01-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("m_reply")
public class Reply implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 回复的id
     */
    @TableId(value = "reply_id", type = IdType.AUTO)
    private Long replyId;

    /**
     * 回复的具体内容
     */
    private String replyContent;

    /**
     * 回复的对象的Id
     */
    private Long replyToUserId;

    /**
     * 回复对应的评论的ID
     */
    private Long commentId;

    /**
     * 回复的用户id
     */
    private Long replyUserId;

    /**
     * 回复时间
     */
    private String replyTime;


}
