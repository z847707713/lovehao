package cn.lovehao.service;

import cn.lovehao.dto.Page;
import cn.lovehao.dto.RoleDto;
import cn.lovehao.entity.Role;
import cn.lovehao.entity.ZTreeData;

import java.util.List;
import java.util.Set;

public interface RoleService {

    public Set<Role> getRolesByUserName(String username);

    public Set<String> getRoleNamesByUserName(String username);

    public Page<Role> getRolePages(RoleDto roleDto);

    public boolean deleteById(Integer id);

    public Role getRoleById(Integer id);

    public boolean updateById(Role role);

    public boolean addRole(Role role);

    public List<ZTreeData> getZTreeDataByRoleId(Integer id);

}
