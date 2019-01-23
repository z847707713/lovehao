package cn.lovehao.controller.admin;

import cn.lovehao.dto.Page;
import cn.lovehao.dto.RoleDto;
import cn.lovehao.entity.Role;
import cn.lovehao.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RoleController {

    @Autowired
    RoleService roleService;

    @RequestMapping(value = "/roles",method = RequestMethod.GET)
    public String init(){
        return "admin/roles";
    }

    @ResponseBody
    @RequestMapping(value = "/role/list",method = RequestMethod.POST)
    public Page<Role> list(RoleDto roleDto){
        return roleService.getRolePages(roleDto);
    }

}
