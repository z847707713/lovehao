package springtest;

import cn.lovehao.dao.RolePermissionMapper;
import cn.lovehao.dto.BatchForUserAndPermissionDto;
import cn.lovehao.entity.RolePermission;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring-context.xml")
public class RolePermissionTest {

    @Autowired
    RolePermissionMapper rolePermissionMapper;

    @Test
    public void insertBatch(){

        BatchForUserAndPermissionDto batchForUserAndPermissionDto = new BatchForUserAndPermissionDto();
        batchForUserAndPermissionDto.setId(1);
        List<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(2);
        batchForUserAndPermissionDto.setIds(list);
         rolePermissionMapper.insertBatch(batchForUserAndPermissionDto);
    }

    @Test
    public void deleteByRoleId(){
        RolePermission rolePermission = new RolePermission();
        rolePermission.setRoleId(1);
        rolePermissionMapper.deleteByRoleId(rolePermission.getRoleId());
    }

}
