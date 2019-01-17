package cn.lovehao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class ErrorController {

    @RequestMapping("/unauthorized")
    public String unauthorized(){
       return "unauthorized";
    }

    @RequestMapping("/unauthenticated")
    public String unauthenticated(){
        return "login";
    }

}
