package cn.lovehao.service;

import cn.lovehao.dto.Page;
import cn.lovehao.dto.RoleDto;
import cn.lovehao.entity.Role;

import java.util.Set;

public interface RoleService {

    public Set<Role> getRolesByUserName(String username);

    public Set<String> getRoleNamesByUserName(String username);


     public Page<Role> getRolePages(RoleDto roleDto);

}
