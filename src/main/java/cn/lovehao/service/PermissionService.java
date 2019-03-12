package cn.lovehao.service;

import cn.lovehao.dto.Page;
import cn.lovehao.dto.PermissionDto;
import cn.lovehao.entity.Permission;
import cn.lovehao.entity.ZTreeData;

import java.util.List;
import java.util.Set;

public interface PermissionService {

   List<Permission> getAll(Permission permission);

   Set<Permission> getPermissionsByUsername(String username);

   Set<String> getPermissionsStrByUsername(String username);

   Page<Permission> getPermissionPages(PermissionDto permissionDto);

   boolean deleteById(Permission permission);

   Permission getPermissionById(Integer id);

   boolean updateById(Permission permission);

   boolean addPermission(Permission permission);

   List<ZTreeData> getPermissionsForZTree(Integer roleId);

}
