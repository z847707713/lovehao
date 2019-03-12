package springtest.mapper;

import cn.lovehao.dao.RoleMapper;
import cn.lovehao.entity.ZTreeData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring-context.xml")
public class RoleMapperTest {

    @Autowired
    private RoleMapper roleMapper;

    @Test
    public void test(){


       List<ZTreeData> data = roleMapper.selectRolesForZTree(1);

        System.out.println(data);
    }

}
