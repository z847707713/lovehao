package cn.lovehao.controller.admin;

import cn.lovehao.dto.Page;
import cn.lovehao.dto.PermissionDto;
import cn.lovehao.entity.Permission;
import cn.lovehao.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PermissionController {

    @Autowired
    PermissionService permissionService;

    @RequestMapping(value = "/permissions",method = RequestMethod.GET)
    public String init(){
        return "admin/permissions";
    }

    @ResponseBody
    @RequestMapping(value = "/permission/list",method = RequestMethod.POST)
    public Page<Permission> list(PermissionDto permissionDto){
        return permissionService.getPermissionPages(permissionDto);
    }

}
