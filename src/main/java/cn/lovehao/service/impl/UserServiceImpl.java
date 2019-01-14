package cn.lovehao.service.impl;

import cn.lovehao.dao.UserDao;
import cn.lovehao.entity.User;
import cn.lovehao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public boolean addUser(User user) {
        try{
          if(userDao.insert(user) > 0){
              return true;
          }
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteUser(User user) {
        try{
            if(userDao.delete(user) > 0 ){
                return true;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public User getUserById(User user) {
        return userDao.selectById(user);
    }

    @Override
    public User getUserByUsername(User user) {
        return userDao.selectByName(user);
    }
}
