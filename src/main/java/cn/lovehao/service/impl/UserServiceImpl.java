package cn.lovehao.service.impl;

import cn.lovehao.Utils.MD5Util;
import cn.lovehao.dao.UserMapper;
import cn.lovehao.dto.Page;
import cn.lovehao.dto.ResponseMsg;
import cn.lovehao.dto.UserDto;
import cn.lovehao.entity.User;
import cn.lovehao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public ResponseMsg<User> addUser(User user) {
        if(userMapper.selectByName(user) != null){
            return new ResponseMsg<>(null,ResponseMsg.ERROR_CODE,"用户名重复");
        }
        if(user != null){
            user.setDeleteFlag(false);
            user.setPassword(MD5Util.getMD5(user.getUsername(),user.getPassword()));
            try{
                if(userMapper.insert(user) > 0){
                    return new ResponseMsg<>(null,ResponseMsg.SUCCESS_CODE,ResponseMsg.SUCCESS);
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        return new ResponseMsg<>(null,ResponseMsg.ERROR_CODE,ResponseMsg.ERROR);
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
    public boolean update(User user) {
        try{
            if(userMapper.update(user) > 0){
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

    @Override
    public Page<User> getUsersPageData(UserDto userDto) {
        Page<User> page = new Page<>();
        try{
            page.setTotalPage(userMapper.selectCount(userDto));
            page.setData(userMapper.selectAllUsers(userDto));
        } catch (Exception e){
            e.printStackTrace();
        }
        return page;
    }
}
