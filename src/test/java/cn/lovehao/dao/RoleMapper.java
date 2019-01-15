package cn.lovehao.dao;

import cn.lovehao.entity.Role;

public interface RoleMapper {
    int insert(Role record);

    int insertSelective(Role record);
}