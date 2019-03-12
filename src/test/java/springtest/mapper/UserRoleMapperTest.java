package springtest.mapper;

import cn.lovehao.dao.RoleMapper;
import cn.lovehao.dao.UserRoleMapper;
import cn.lovehao.dto.BatchForUserAndPermissionDto;
import cn.lovehao.entity.UserRole;
import cn.lovehao.entity.ZTreeData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring-context.xml")
public class UserRoleMapperTest {

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Test
    public void test(){
        BatchForUserAndPermissionDto batchForUserAndPermissionDto = new BatchForUserAndPermissionDto();
        batchForUserAndPermissionDto.setId(1);
        List<Integer> list = new ArrayList<>();
        list.add(1);
        batchForUserAndPermissionDto.setIds(list);
        userRoleMapper.insertBatch(batchForUserAndPermissionDto);
    }

    @Test
    public void deleteTest(){

        UserRole userRole = new UserRole();
        userRole.setUserId(1);
        userRoleMapper.deleteByUserId(userRole.getId());
    }

}
