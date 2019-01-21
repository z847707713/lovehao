package cn.lovehao.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PermissionController {

    @RequestMapping(value = "/permission",method = RequestMethod.GET)
    public String init(){
        return "admin/permissions";
    }

}
