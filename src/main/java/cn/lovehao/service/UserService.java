package cn.lovehao.service;

import cn.lovehao.dto.Page;
import cn.lovehao.dto.UserDto;
import cn.lovehao.entity.User;

public interface UserService {

    public boolean addUser(User user);

    public boolean deleteUser(User user);

    public boolean update(User user);

    public User getUserById(User user);

    public User getUserByUsername(User user);

    public Page<User> getUsersPageData(UserDto userDto);

}
