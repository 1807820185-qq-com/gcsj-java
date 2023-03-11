package com.example.controller;


import com.example.common.lang.Result;
import com.example.entity.Article;
import com.example.entity.Comment;
import com.example.service.ArticleService;
import com.example.vo.ArticleVo;
import com.example.vo.CommentReplyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 关注公众号：example
 * @since 2023-01-22
 */
@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;



    @RequestMapping("/getArticle")
    public Result getArticle(){
        try {
            List<ArticleVo> articleList= articleService.queryAllArticleList();
            return Result.succ(articleList);
        }catch (Exception e){
            return Result.fail(e.getMessage());
        }


    }
    /**
     * 通过文章Id查询文章
      */
    @PostMapping("getArticleById/articleId/{articleId}")
    public Result getArticleById(@PathVariable("articleId") Integer articleId){
        try {
            Article res=articleService.queryArticleById(articleId);
            return Result.succ(res);
        }catch (Exception e){
            return Result.fail(e.getMessage());
        }
    }

    /**
     * 发表文章
     * @param article
     * @return
     */
    @PostMapping("/publish")
    public Result publish(@RequestBody Article article){


        try{
            articleService.publish(article);
            return Result.succ("保存成功");
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail(e.getMessage());
        }

    }


}
