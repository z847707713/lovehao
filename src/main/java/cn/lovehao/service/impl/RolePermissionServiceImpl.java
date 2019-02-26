package cn.lovehao.service.impl;

import cn.lovehao.dao.RolePermissionMapper;
import cn.lovehao.dto.RolePermissionDto;
import cn.lovehao.service.RolePermissionService;
import org.omg.CORBA.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RolePermissionServiceImpl implements RolePermissionService {

    @Autowired
    RolePermissionMapper rolePermissionMapper;

    @Transactional
    @Override
    public boolean addPermissions(RolePermissionDto rolePermissionDto) throws RuntimeException {
         rolePermissionMapper.deleteByRoleId(rolePermissionDto.getRoleId());
         if(rolePermissionDto.getRoleId() == 1){
             throw new RuntimeException("111");
         }
        rolePermissionMapper.insertBatch(rolePermissionDto);
        return false;
    }
}
