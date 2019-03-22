package cn.lovehao.service.impl;

import cn.lovehao.dao.ArticlePhotoMapper;
import cn.lovehao.entity.ArticlePhoto;
import cn.lovehao.service.ArticlePhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticlePhotoServiceImpl implements ArticlePhotoService {

    @Autowired
    ArticlePhotoMapper articlePhotoMapper;

    @Override
    public boolean add(ArticlePhoto articlePhoto) {
        try{
            if(articlePhotoMapper.insertSelective(articlePhoto) > 0){
                return true;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(ArticlePhoto articlePhoto) {
        try{
            if( articlePhotoMapper.updateByPrimaryKeySelective(articlePhoto) > 0){
                return true;
            }
        } catch (Exception e){
         e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(ArticlePhoto articlePhoto) {
        try{
            if(articlePhotoMapper.deleteByPrimaryKey(articlePhoto.getId()) > 0){
                 return true;
            }
        } catch (Exception e){
          e.printStackTrace();
        }
        return false;
    }
}
