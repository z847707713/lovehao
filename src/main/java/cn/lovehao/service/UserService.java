package cn.lovehao.service;

import cn.lovehao.entity.User;

public interface UserService {

    public boolean addUser(User user);

    public boolean deleteUser(User user);

    public User getUserById(User user);

    public User getUserByUsername(User user);

}
