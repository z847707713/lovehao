package cn.lovehao.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/userRole")
public class UserRoleController {


    @RequestMapping("/view")
    public String view(){
        return "/admin/userRole";
    }

}
