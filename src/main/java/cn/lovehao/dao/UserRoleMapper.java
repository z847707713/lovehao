package cn.lovehao.dao;

import cn.lovehao.dto.BatchForUserAndPermissionDto;
import cn.lovehao.entity.UserRole;

public interface UserRoleMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    UserRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);

    int deleteByUserId(Integer id);

    int insertBatch(BatchForUserAndPermissionDto dto);

}