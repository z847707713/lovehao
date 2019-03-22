package cn.lovehao.service.impl;

import cn.lovehao.Utils.SetUserAndDateUtils;
import cn.lovehao.dao.ArticleMapper;
import cn.lovehao.dao.ArticlePhotoMapper;
import cn.lovehao.dto.ArticleDto;
import cn.lovehao.entity.Article;
import cn.lovehao.entity.ArticlePhoto;
import cn.lovehao.service.ArticelService;
import cn.lovehao.service.ArticlePhotoService;
import cn.lovehao.service.UploadService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

@Service
public class ArticelServiceImpl implements ArticelService {

    @Autowired
    ArticleMapper articleMapper;


    @Autowired
    ArticlePhotoMapper articlePhotoMapper;

    @Autowired
    UploadService uploadService;

    @Override
    @Transactional
    public boolean add(Article article, MultipartFile file, HttpServletRequest request) {
        try{
            SetUserAndDateUtils.setUserAndDate(article);
            articleMapper.insertSelective(article);
            if(uploadService.uploadArticleImg(file,request,article.getId())){
                return true;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    @Transactional
    public boolean update(Article article, MultipartFile file, HttpServletRequest request) {

            String realPath = null;

            //当上传的图片不为空，表示修改了图片
            if(file != null){
                ArticlePhoto newArticlePhoto = uploadService.uploadImgAndGetPojo(file,request);   //新数据
                ArticlePhoto oldaRrticlePhoto = articlePhotoMapper.selectByArticleId(article.getId());  //旧数据
                newArticlePhoto.setId(oldaRrticlePhoto.getId());
                articlePhotoMapper.updateByPrimaryKeySelective(newArticlePhoto);  //更新图片信息
                realPath = oldaRrticlePhoto.getRealPath();
            }

            SetUserAndDateUtils.setUpdateUserAndDate(article);
            if(articleMapper.updateByPrimaryKeySelective(article) > 0){
                    //文章数据更新成功，删除图片
                try{
                    if(realPath != null){
                        File imgFile = new File(realPath);
                        if(imgFile.exists()){
                            imgFile.delete();
                        }
                    }
                } catch (Exception e){
                    e.printStackTrace();
                }
                return true;
            }
        return false;
    }

    @Override
    public boolean delete(Article article) {
        try{
            if( articleMapper.deleteByPrimaryKey(article.getId())> 0){
               return true;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Page<ArticleDto> getAll(ArticleDto articleDto, Integer pageNum, Integer pageSize) {
        return PageHelper.startPage(pageNum,pageSize).doSelectPage(() -> articleMapper.selectAll(articleDto));
    }

    @Override
    public ArticleDto getById(ArticleDto article) {
        return articleMapper.selectArticleAndPhoto(article);
    }

    @Override
    public Article getArticleById(Integer id) {
        return articleMapper.selectByPrimaryKey(id);
    }
}
