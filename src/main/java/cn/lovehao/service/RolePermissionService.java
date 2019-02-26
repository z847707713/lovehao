package cn.lovehao.service;

import cn.lovehao.dto.RolePermissionDto;
import org.omg.CORBA.SystemException;

public interface RolePermissionService {

    public boolean addPermissions(RolePermissionDto rolePermissionDto) throws SystemException;

}
