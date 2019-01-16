package cn.lovehao.dao;

import cn.lovehao.entity.User;

public interface UserMapper {

    public User selectById(User user);

    public User selectByName(User user);

    public int insert(User user);

    public int delete(User user);

}
