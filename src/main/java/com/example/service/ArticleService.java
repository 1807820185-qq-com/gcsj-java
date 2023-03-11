package com.example.service;

import com.example.entity.Article;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.vo.ArticleVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 关注公众号：example
 * @since 2023-01-22
 */
public interface ArticleService extends IService<Article> {
    /**
     * 查询所有的文章列表
     * @return
     */
    List<ArticleVo> queryAllArticleList();
    /**
     * 通过文章Id查询文章
     * @return
     */
    Article queryArticleById(Integer articleId);
    /**
     * 发布文章
     * @param article
     * @return
     */
    void publish(Article article);

}
