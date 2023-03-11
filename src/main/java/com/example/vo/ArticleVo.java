package com.example.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author 关注公众号：example
 * @since 2023-01-22
 */
@Data
public class ArticleVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 文章id
     */
    private Long articleId;

    /**
     * 文章作者
     */
    private String articleAuthor;

    /**
     * 文章标题
     */
    private String articleTitle;

    /**
     * 文章摘要
     */
    private String articleSummary;

    /**
     * 文章内容
     */
    private String articleContent;


    /**
     * 文章中的图片
     */
    private String articleImage;

    /**
     * 发布文章的用户的id
     */
    private Long userId;

    /**
     * 文章获赞数量
     */
    private Integer articleGoodNum;

    /**
     * 文章发布的时间
     */
    private String createTime;


}
