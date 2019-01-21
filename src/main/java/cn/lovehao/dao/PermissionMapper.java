package cn.lovehao.dao;

import cn.lovehao.dto.PermissionDto;
import cn.lovehao.entity.Permission;

import java.util.List;
import java.util.Set;

public interface PermissionMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);

    List<Permission> selectAll(Permission record);

    Set<Permission> selectPermissionsByUsername(String username);

    Set<String> selectPermissionsStrByUsername(String username);

    List<Permission> selectAllPermission(PermissionDto permissionDto);

}