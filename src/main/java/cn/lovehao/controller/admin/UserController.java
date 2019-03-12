package cn.lovehao.controller.admin;

import cn.lovehao.dto.Page;
import cn.lovehao.dto.ResponseMsg;
import cn.lovehao.dto.UserDto;
import cn.lovehao.entity.User;
import cn.lovehao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    private final String USERS_VIEW = "admin/users";    //用户列表页面

    private final String ADD_EDIT_VIEW = "admin/user";  //新增或修改页面
    /**
     *  用户列表页
     * @return
     */
    @RequestMapping(value = "/users",method = RequestMethod.GET)
    public String listView(){
        return USERS_VIEW;
    }

    /**
     *  获取分页数据
     * @param userDto
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/user/list",method = RequestMethod.POST)
    public Page<User> list(UserDto userDto){
        return userService.getUsersPageData(userDto);
    }


    /**
     *  用户新增
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public ResponseMsg<User> add(User user){
        return userService.addUser(user);
    }

    /**
     * 用户删除
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/user",method = RequestMethod.DELETE)
    public ResponseMsg<User> delete(User user){
        if(userService.deleteUser(user)){
            return new ResponseMsg<>(null,ResponseMsg.SUCCESS_CODE,ResponseMsg.SUCCESS);
        }
        return new ResponseMsg<>(null,ResponseMsg.ERROR_CODE,ResponseMsg.ERROR);
    }

    /**
     * 用户修改
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/user",method = RequestMethod.PUT)
    public ResponseMsg<List<FieldError>> edit(@Validated User user, BindingResult br){
        int count = br.getErrorCount();
        if(count > 0){
            return new ResponseMsg<>(br.getFieldErrors(),ResponseMsg.ERROR_CODE,ResponseMsg.SUCCESS);
        }
        if(userService.update(user)){
            return new ResponseMsg<>(null,ResponseMsg.SUCCESS_CODE,ResponseMsg.SUCCESS);
        }
        return new ResponseMsg<>(null,ResponseMsg.ERROR_CODE,ResponseMsg.ERROR);
    }

    /**
     * 添加页面
     * @return
     */
    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String addView(Map<String,Object> map){
        map.put("flag",true);
        return ADD_EDIT_VIEW;
    }

    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    public String editView(@PathVariable Integer id, Map<String,Object> map){
        User user = new User(id);
        map.put("user",userService.getUserById(user));
        return ADD_EDIT_VIEW;
    }

}
