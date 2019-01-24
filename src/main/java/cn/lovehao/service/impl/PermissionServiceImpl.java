package cn.lovehao.service.impl;

import cn.lovehao.dao.PermissionMapper;
import cn.lovehao.dto.Page;
import cn.lovehao.dto.PermissionDto;
import cn.lovehao.entity.Permission;
import cn.lovehao.service.PermissionService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    PermissionMapper permissionMapper;

    @RequiresRoles("admin")
    @Override
    public List<Permission> getAll(Permission permission) {
        return permissionMapper.selectAll(permission);
    }

    public Set<Permission> getPermissionsByUsername(String username){
        try{
          return permissionMapper.selectPermissionsByUsername(username);
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Set<String> getPermissionsStrByUsername(String username) {
        try{
           return permissionMapper.selectPermissionsStrByUsername(username);
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Page<Permission> getPermissionPages(PermissionDto permissionDto) {
        try{
            Page<Permission> result = permissionMapper.selectAllPermission(permissionDto);
            if(result == null){
                result = new Page<>();
            }
            result.setTotalPage(permissionMapper.selectCount(permissionDto));
            return result;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean deleteById(Permission permission) {
        try{
            if(permissionMapper.deleteByPrimaryKey(permission.getId()) > 0){
                return true;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

}
