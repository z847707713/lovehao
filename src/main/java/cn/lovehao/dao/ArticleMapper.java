package cn.lovehao.dao;

import cn.lovehao.dto.ArticleDto;
import cn.lovehao.entity.Article;
import com.github.pagehelper.Page;

import java.util.List;

public interface ArticleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Article record);

    int insertSelective(Article record);

    Article selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKeyWithBLOBs(Article record);

    int updateByPrimaryKey(Article record);

    Page<ArticleDto> selectAll(ArticleDto articleDto);

    ArticleDto selectArticleAndPhoto(ArticleDto articleDto);

}