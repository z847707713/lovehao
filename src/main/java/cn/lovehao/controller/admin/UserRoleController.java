package cn.lovehao.controller.admin;

import cn.lovehao.dto.RolePermissionDto;
import cn.lovehao.entity.PermissionForZTree;
import cn.lovehao.service.PermissionService;
import cn.lovehao.service.RolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/userRole")
public class UserRoleController {

    @Autowired
    PermissionService permissionService;

    @Autowired
    RolePermissionService rolePermissionService;

    @RequestMapping("/view/{id}")
    public String view(@PathVariable Integer id, Map<String,Object> map){
        map.put("id",id);
        return "/admin/userRole";
    }

    @ResponseBody
    @RequestMapping("/tree")
    public List<PermissionForZTree> getTree(Integer roleId){
        return permissionService.getPermissionsForZTree(roleId);
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public String distPermissions(@RequestBody RolePermissionDto rolePermissionDto){
        rolePermissionService.addPermissions(rolePermissionDto);
        return "";
    }

}


