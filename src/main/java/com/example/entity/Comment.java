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
@TableName("m_comment")
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 评论的id
     */
    @TableId(value = "comment_id", type = IdType.AUTO)
    private Long commentId;

    /**
     * 评论的内容
     */
    private String commentContent;

    /**
     * 评论的文章id
     */
    private Long commentArticleId;

    /**
     * 评论的用户id
     */
    private Long commentUserId;

    /**
     * 评论时间
     */
    private String commentTime;


}
