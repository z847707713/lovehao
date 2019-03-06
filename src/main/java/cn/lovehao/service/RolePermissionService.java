package cn.lovehao.service;

import cn.lovehao.dto.BatchForUserAndPermissionDto;
import org.omg.CORBA.SystemException;

public interface RolePermissionService {

    public boolean addPermissions(BatchForUserAndPermissionDto batchForUserAndPermissionDto) throws SystemException;

}
