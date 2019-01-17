package cn.lovehao.service.impl;

import cn.lovehao.dao.PermissionMapper;
import cn.lovehao.entity.Permission;
import cn.lovehao.service.PermissionService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    PermissionMapper permissionMapper;

    @RequiresRoles("admin")
    @Override
    public List<Permission> getAll(Permission permission) {
        return permissionMapper.selectAll(permission);
    }


}
