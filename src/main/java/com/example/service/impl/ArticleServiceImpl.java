package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.entity.Article;
import com.example.mapper.ArticleMapper;
import com.example.service.ArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.vo.ArticleVo;
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
 * @since 2023-01-22
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

    @Autowired
    ArticleMapper articleMapper;
    /**
     * 查询所有的文章列表
     * @return
     */
    @Override
    public List<ArticleVo> queryAllArticleList() {
//        QueryWrapper<Article> queryWrapper = new QueryWrapper<>();
//        queryWrapper.select("article_id","article_title","article_summary","article_good_num","article_image","create_time");
//        queryWrapper.orderByDesc("create_time");
//        return articleMapper.selectList(queryWrapper);
        return articleMapper.queryAllArticleList();
    }
    /**
     * 通过文章Id查询文章
     * @return
     */
    @Override
    public Article queryArticleById(Integer articleId) {

        return this.getById(articleId);
    }

    @Override
    public void publish(Article article) {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String day = format.format(date);
        article.setArticleGoodNum(0);
        article.setCreateTime(day);
        this.save(article);

    }
}
