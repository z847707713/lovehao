package springtest.service;

import cn.lovehao.dto.Page;
import cn.lovehao.dto.UserDto;
import cn.lovehao.entity.User;
import cn.lovehao.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring-context.xml")
public class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    public void pageTest(){
        UserDto userDto = new UserDto();
        userDto.setPageShowCount(2);
        userDto.setCurrentPage(1);
        Page<User> page =  userService.getUsersPageData(userDto);
        System.out.println(page);
    }

}
