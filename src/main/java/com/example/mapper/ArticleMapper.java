package com.example.mapper;

import com.example.entity.Article;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.vo.ArticleVo;
import com.example.vo.ReplyVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 关注公众号：example
 * @since 2023-01-22
 */
@Mapper
public interface ArticleMapper extends BaseMapper<Article> {
    List<ArticleVo> queryAllArticleList();

}
