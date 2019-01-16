package cn.lovehao.controller;

import cn.lovehao.entity.Permission;
import cn.lovehao.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class TestController {

    @Autowired
    PermissionService permissionService;

    @RequestMapping("/permission")
    @ResponseBody
    public List<Permission> permission(Permission permission){
        return permissionService.getAll(permission);
    }

    @RequestMapping("/edit")
    public String edit(){
        return "/edit/edit";
    }

    @RequestMapping("/test")
    public String test(HttpServletRequest req, HttpServletResponse resp){
       return "forward:/views/edit/test.jsp";
    }

}
