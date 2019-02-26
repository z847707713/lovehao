package springtest;

import cn.lovehao.dao.PermissionMapper;
import cn.lovehao.entity.Permission;
import cn.lovehao.entity.PermissionForZTree;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.sound.sampled.Line;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring-context.xml")
public class PermissionsTest {

    @Autowired
    private PermissionMapper permissionMapper;


    @Test
    public void  insert(){
        Permission permission = new Permission();
        permission.setPermission("test01");
        permission.setType(false);
        permission.setUrl("/test01");
        permission.setPermissionName("测试01");
        permission.setPermissionDesc("测试数据01");
        permission.setParent(0);
        permissionMapper.insert(permission);
    }


    @Test
    public void  delete(){
        Permission permission = new Permission();
        permissionMapper.deleteByPrimaryKey(14);
    }

    @Test
    public void insertSelective(){
        Permission permission = new Permission();
        permission.setPermission("test01");
        permission.setType(false);
        permission.setUrl("/test01");
        permission.setPermissionName("测试01");
        permission.setPermissionDesc("测试数据01");
        permission.setParent(0);
        permissionMapper.insertSelective(permission);
    }

    @Test
    public void updateByPrimaryKey(){

        Permission permission = new Permission();
        permission.setId(14);
        permission.setPermission("test01:update");
        permission.setType(false);
        permission.setUrl("/test01/update");
        permission.setPermissionName("测试01:update");
        permission.setPermissionDesc("测试数据01:update");
        permission.setParent(1);
        permissionMapper.updateByPrimaryKey(permission);
    }

    @Test
    public void updateSelective(){
        Permission permission = new Permission();
        permission.setId(14);
        permission.setPermission("test01:updateSelective");
        permission.setType(true);
        permission.setUrl("/test01/updateSelective");
        permission.setPermissionName("测试01:updateSelective");
        permission.setPermissionDesc("测试数据01:updateSelective");
        permission.setParent(0);
        permissionMapper.updateByPrimaryKeySelective(permission);
    }

    @Test
    public void selectByPrimaryKey(){
        Permission permission = permissionMapper.selectByPrimaryKey(15);
        System.out.println(permission);
    }

    @Test
    public void selectAll(){
        Permission permission = new Permission();
        List<Permission> permissions = permissionMapper.selectAll(permission);
        System.out.println(permissions);
    }

    @Test
    public void selectPermissionForZTree(){
        List<PermissionForZTree> permissionForZTrees = permissionMapper.selectPermissionForZTree(1);
        System.out.println(permissionForZTrees);
    }

}
