package cn.lovehao.service.impl;

import cn.lovehao.dao.RolePermissionMapper;
import cn.lovehao.dto.BatchForUserAndPermissionDto;
import cn.lovehao.service.RolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RolePermissionServiceImpl implements RolePermissionService {

    @Autowired
    RolePermissionMapper rolePermissionMapper;

    @Transactional
    @Override
    public boolean addPermissions(BatchForUserAndPermissionDto batchForUserAndPermissionDto) throws RuntimeException {
        rolePermissionMapper.deleteByRoleId(batchForUserAndPermissionDto.getId());
        if(batchForUserAndPermissionDto.getIds().size() <= 0){
            return true;
        }
        if(rolePermissionMapper.insertBatch(batchForUserAndPermissionDto) > 0){
            return true;
        }
        return false;
    }
}
