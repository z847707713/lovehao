package cn.lovehao.Utils;

import cn.lovehao.entity.BaseEntity;
import cn.lovehao.entity.User;
import org.apache.shiro.SecurityUtils;

import java.util.Date;

public class SetUserAndDateUtils{

    public static <T extends BaseEntity> void setUserAndDate(T t){
        Date date = new Date();
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        t.setUpdateTime(date);
        t.setUpdateUser(user.getUsername());
        t.setCreateTime(date);
        t.setCreateUser(user.getUsername());
    }

    public static <T extends BaseEntity> void setUpdateUserAndDate(T t){
        Date date = new Date();
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        t.setUpdateTime(date);
        t.setUpdateUser(user.getUsername());
    }

}
