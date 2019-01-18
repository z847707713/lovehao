package cn.lovehao.dao;

import cn.lovehao.entity.Role;
import cn.lovehao.entity.User;

import java.util.Set;

public interface RoleMapper {

    int insert(Role record);

    int insertSelective(Role record);

    Set<Role> selectRolesByUserName(String username);

    Set<String> selectRoleNamesByUsername(String username);

}