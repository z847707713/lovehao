package cn.lovehao.service.impl;

import cn.lovehao.dao.UserRoleMapper;
import cn.lovehao.dto.BatchForUserAndPermissionDto;
import cn.lovehao.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    @Transactional
    public boolean distRoles(BatchForUserAndPermissionDto dto) {
        userRoleMapper.deleteByUserId(dto.getId());
        userRoleMapper.insertBatch(dto);
        return true;
    }
}
