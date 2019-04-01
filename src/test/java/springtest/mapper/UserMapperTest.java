package springtest.mapper;

import cn.lovehao.dao.UserMapper;
import cn.lovehao.dto.Page;
import cn.lovehao.dto.UserDto;
import cn.lovehao.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring-context.xml")
public class UserMapperTest {

    @Autowired
    UserMapper userMapper;

    @Test
    public void pageTest(){

        UserDto userDto = new UserDto();
        userDto.setCurrentPage(1);
        userDto.setPageShowCount(2);
        List<User> users =  userMapper.selectAllUsers(userDto);
        System.out.println(users);
    }

}
