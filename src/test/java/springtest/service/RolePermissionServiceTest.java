package springtest.service;

import cn.lovehao.dto.BatchForUserAndPermissionDto;
import cn.lovehao.service.RolePermissionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring-context.xml")
public class RolePermissionServiceTest {

    @Autowired
    RolePermissionService rolePermissionService;

    @Test
    @Transactional
    public void addPermission(){

        BatchForUserAndPermissionDto batchForUserAndPermissionDto = new BatchForUserAndPermissionDto();
        batchForUserAndPermissionDto.setId(1);
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        rolePermissionService.addPermissions(batchForUserAndPermissionDto);
    }

}
