package cn.lovehao.service.impl;

import cn.lovehao.dao.UserMapper;
import cn.lovehao.entity.User;
import cn.lovehao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public boolean addUser(User user) {
        try{
          if(userMapper.insert(user) > 0){
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
            if(userMapper.delete(user) > 0 ){
                return true;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public User getUserById(User user) {
        try{
            return userMapper.selectById(user);
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User getUserByUsername(User user) {
        try{
            return  userMapper.selectByName(user);
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
