package springtest.service;

import cn.lovehao.dao.ArticleMapper;
import cn.lovehao.dto.ArticleDto;
import cn.lovehao.entity.Article;
import cn.lovehao.service.ArticelService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring-context.xml")
public class ArticleServiceTest {

    @Autowired
    private ArticelService articelService;

    @Test
    public void test(){
        Page<ArticleDto> pages = articelService.getAll(new ArticleDto(),1,2);
        System.out.println(pages);
    }






}
