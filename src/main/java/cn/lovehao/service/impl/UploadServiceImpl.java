package cn.lovehao.service.impl;

import cn.lovehao.Utils.CommonUtils;
import cn.lovehao.dto.EditUploadDto;
import cn.lovehao.entity.ArticlePhoto;
import cn.lovehao.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Service
public class UploadServiceImpl implements UploadService {

    private static final String WEB_UPLOAD_PATH = "/common/upload/img/";

    private static final String POINT = ".";

    private static final String UNDER_LINE = "_";

    private static final String TYPE = "0";

    private static final String BACKSLASH = "/";

    //private static final String LOCAL_PATH = "";

    @Autowired
    ArticlePhotoServiceImpl articlePhotoService;

    @Override
    public EditUploadDto uploadEditImg(MultipartFile file, HttpServletRequest request, HttpServletResponse response) {
        String fileName = upload(file, request);

        String url = getUrl(request, fileName);

        EditUploadDto editUploadDto = new EditUploadDto();
        editUploadDto.setUrl(url);
        editUploadDto.setSuccess(1);
        editUploadDto.setMessage("success");
        return editUploadDto;
    }

    private String getUrl(HttpServletRequest request, String fileName) {
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();

        return basePath+ WEB_UPLOAD_PATH + fileName;
    }

    private String upload(MultipartFile file, HttpServletRequest request) {
        String trueFileName = file.getOriginalFilename();

        String suffix = trueFileName.substring(trueFileName.lastIndexOf(POINT));

        String fileName = System.currentTimeMillis() + UNDER_LINE + CommonUtils.getRandomNumber() + suffix;

        String path = getRealPath(request);
        System.out.println(path);

        File targetFile = new File(path, fileName);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }

        //保存
        try {
            file.transferTo(targetFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileName;
    }

    private String getRealPath(HttpServletRequest request) {
        return request.getSession().getServletContext().getRealPath(WEB_UPLOAD_PATH);
    }

    @Override
    public boolean uploadArticleImg(MultipartFile file, HttpServletRequest request,Integer id) {
        String fileName = upload(file, request);
        String realPath = getRealPath(request) + BACKSLASH + fileName;
//        String url = WEB_UPLOAD_PATH + fileName;
        String url = getUrl(request,fileName);
        ArticlePhoto articlePhoto = new ArticlePhoto();
        articlePhoto.setArticleId(id);
        articlePhoto.setRealPath(realPath);
        articlePhoto.setUrl(url);
        articlePhoto.setType(TYPE);
        try{
            if(articlePhotoService.add(articlePhoto)){
                return true;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public ArticlePhoto uploadImgAndGetPojo(MultipartFile file, HttpServletRequest request) {
        String fileName = upload(file, request);
        String realPath = getRealPath(request) + BACKSLASH + fileName;
//        String url = WEB_UPLOAD_PATH + fileName;
        String url = getUrl(request,fileName);
        ArticlePhoto articlePhoto = new ArticlePhoto();
        articlePhoto.setRealPath(realPath);
        articlePhoto.setUrl(url);
        articlePhoto.setType(TYPE);
        return articlePhoto;
    }


}
