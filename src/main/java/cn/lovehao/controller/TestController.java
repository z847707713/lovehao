package cn.lovehao.controller;

import cn.lovehao.entity.Permission;
import cn.lovehao.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

}
