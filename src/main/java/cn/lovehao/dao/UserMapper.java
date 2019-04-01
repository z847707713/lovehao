package cn.lovehao.dao;

import cn.lovehao.dto.Page;
import cn.lovehao.dto.PermissionDto;
import cn.lovehao.dto.UserDto;
import cn.lovehao.entity.Permission;
import cn.lovehao.entity.User;

import java.util.List;

public interface UserMapper {

    public User selectById(User user);

    public User selectByName(User user);

    public int update(User user);

    public int insert(User user);

    public int delete(User user);

    List<User> selectAllUsers(UserDto userDto);

    Integer selectCount(UserDto userDto);
}
