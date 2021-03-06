package cn.lovehao.dao;

import cn.lovehao.dto.Page;
import cn.lovehao.dto.RoleDto;
import cn.lovehao.entity.Permission;
import cn.lovehao.entity.Role;
import cn.lovehao.entity.User;
import cn.lovehao.entity.ZTreeData;

import java.util.List;
import java.util.Set;

public interface RoleMapper {

    int insert(Role record);

    int insertSelective(Role record);

    Set<Role> selectRolesByUserName(String username);

    Set<String> selectRoleNamesByUsername(String username);

    int updateByPrimaryKeySelective(Role record);

    int deleteByPrimaryKey(Integer id);

    Role selectByPrimaryKey(Integer id);

    Page<Role> selectAllRoles(RoleDto roleDto);

    Integer selectCount(RoleDto roleDto);

    List<ZTreeData> selectRolesForZTree(Integer roleId);


}