package cn.lovehao.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class roleController {

    @RequestMapping(value = "/roles",method = RequestMethod.GET)
    public String init(){
        return "admin/roles";
    }

}
