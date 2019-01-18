package cn.lovehao.service;

import cn.lovehao.entity.Permission;

import java.util.List;
import java.util.Set;

public interface PermissionService {

   List<Permission> getAll(Permission permission);

   Set<Permission> getPermissionsByUsername(String username);

   Set<String> getPermissionsStrByUsername(String username);


}
