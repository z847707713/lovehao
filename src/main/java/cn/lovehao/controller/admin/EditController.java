package cn.lovehao.controller.admin;

import cn.lovehao.dto.EditUploadDto;
import cn.lovehao.dto.ResponseMsg;
import cn.lovehao.entity.Article;
import cn.lovehao.service.ArticelService;
import cn.lovehao.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequestMapping("/edit")
@Controller
public class EditController {


    @Autowired
    private ArticelService articelService;

    @Autowired
    private UploadService uploadService;

    @RequestMapping(method = RequestMethod.GET)
    public String edit(){
        return "/edit/edit";
    }

    @ResponseBody
    @RequestMapping("/upload")
    public EditUploadDto uploadImg(@RequestParam(value = "editormd-image-file", required = true) MultipartFile file, HttpServletRequest request, HttpServletResponse response){
        return uploadService.uploadEditImg(file,request,response);
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public ResponseMsg<Article> save(@RequestParam(value = "file",required = true) MultipartFile file,Article article,HttpServletRequest request){
        if(articelService.add(article,file,request)){
            return new ResponseMsg<>(null,ResponseMsg.SUCCESS_CODE,ResponseMsg.SUCCESS);
        }
        return new ResponseMsg<>(null,ResponseMsg.ERROR_CODE,ResponseMsg.ERROR);
    }


}
