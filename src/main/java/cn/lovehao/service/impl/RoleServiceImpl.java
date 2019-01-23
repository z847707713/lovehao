package cn.lovehao.service.impl;

import cn.lovehao.dao.RoleMapper;
import cn.lovehao.dto.Page;
import cn.lovehao.dto.RoleDto;
import cn.lovehao.entity.Role;
import cn.lovehao.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleMapper roleMapper;

    @Override
    public Set<Role> getRolesByUserName(String username) {
        try{
            return (Set<Role>) roleMapper.selectRolesByUserName(username);
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Set<String> getRoleNamesByUserName(String username) {
        try{
            return  roleMapper.selectRoleNamesByUsername(username);
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Page<Role> getRolePages(RoleDto roleDto) {
        try{
            Page<Role>  result = roleMapper.selectAllRoles(roleDto);
            if(result == null){
                result = new Page<>();
            }
            result.setTotalPage(roleMapper.selectCount(roleDto));
            return result;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
