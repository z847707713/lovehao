package cn.lovehao.controller.admin;

import cn.lovehao.dto.ArticleDto;
import cn.lovehao.dto.ResponseMsg;
import cn.lovehao.entity.Article;
import cn.lovehao.service.ArticelService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import javafx.scene.chart.ValueAxis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    ArticelService articelService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String BlogList(){
        return "/blog/list";
    }

    @ResponseBody
    @RequestMapping(value = "/list",method = RequestMethod.POST)
    public PageInfo<ArticleDto> list(ArticleDto articleDto, Integer pageNum, Integer pageSize){
        Page<ArticleDto>  pageData = articelService.getAll(articleDto,pageNum,pageSize);
        return pageData.toPageInfo();
    }

    @RequestMapping(value = "/edit",method = RequestMethod.GET)
    public String editView(ArticleDto articleDto, Map<String,Object> map){
        articleDto = articelService.getById(articleDto);
        map.put("result",articleDto);
        return "/blog/edit";
    }

    @ResponseBody
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public ResponseMsg<ArticleDto> edit(Article article, MultipartFile file, HttpServletRequest request){
        try{
            articelService.update(article,file,request);
            return new ResponseMsg<>(null,ResponseMsg.SUCCESS_CODE,ResponseMsg.SUCCESS);
        } catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseMsg<>(null,ResponseMsg.ERROR_CODE,ResponseMsg.ERROR);
    }




    @ResponseBody
    @RequestMapping("/edit/mdStr")
    public String getMarkdownStr(Integer id){
       return articelService.getArticleById(id).getMarkdown();
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseMsg<ArticleDto> delete(Article article){
        try{
            articelService.delete(article);
            return new ResponseMsg<>(null,ResponseMsg.SUCCESS_CODE,ResponseMsg.SUCCESS);
        } catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseMsg<>(null,ResponseMsg.ERROR_CODE,ResponseMsg.ERROR);
    }


}
