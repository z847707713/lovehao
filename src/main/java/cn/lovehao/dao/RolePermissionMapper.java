package cn.lovehao.dao;

import cn.lovehao.dto.RolePermissionDto;
import cn.lovehao.entity.RolePermission;

public interface RolePermissionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RolePermission record);

    int insertSelective(RolePermission record);

    RolePermission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RolePermission record);

    int updateByPrimaryKey(RolePermission record);

    int insertBatch(RolePermissionDto rolePermissionDto);

    int deleteByRoleId(RolePermission record);

}