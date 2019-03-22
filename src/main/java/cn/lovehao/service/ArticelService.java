package cn.lovehao.service;

import cn.lovehao.dto.ArticleDto;
import cn.lovehao.entity.Article;
import com.github.pagehelper.Page;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

public interface ArticelService {

    public boolean add(Article article, MultipartFile file, HttpServletRequest request);

    public boolean update(Article article,MultipartFile file, HttpServletRequest request);

    public boolean delete(Article article);

    public Page<ArticleDto> getAll(ArticleDto articleDto, Integer pageNum, Integer pageSize);

    public ArticleDto getById(ArticleDto article);

    public Article getArticleById(Integer id);


}
