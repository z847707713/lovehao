package cn.lovehao.service;

import cn.lovehao.dto.EditUploadDto;
import cn.lovehao.entity.ArticlePhoto;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface UploadService {

    public EditUploadDto uploadEditImg(MultipartFile file, HttpServletRequest request, HttpServletResponse response);


    public boolean uploadArticleImg(MultipartFile file, HttpServletRequest request,Integer id);


    public ArticlePhoto uploadImgAndGetPojo(MultipartFile file, HttpServletRequest request);

}
