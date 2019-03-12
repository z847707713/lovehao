package cn.lovehao.controller.admin;

import cn.lovehao.dto.ResponseMsg;
import cn.lovehao.dto.BatchForUserAndPermissionDto;
import cn.lovehao.entity.ZTreeData;
import cn.lovehao.service.PermissionService;
import cn.lovehao.service.RolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/rolePermission")
public class RolePermissionController {

    @Autowired
    PermissionService permissionService;

    @Autowired
    RolePermissionService rolePermissionService;

    @RequestMapping("/view/{id}")
    public String view(@PathVariable Integer id, Map<String,Object> map){
        map.put("id",id);
        return "/admin/rolePermission";
    }

    @ResponseBody
    @RequestMapping("/tree")
    public List<ZTreeData> getTree(Integer roleId){
        return permissionService.getPermissionsForZTree(roleId);
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public ResponseMsg<String> distPermissions(@RequestBody BatchForUserAndPermissionDto batchForUserAndPermissionDto){
        if(rolePermissionService.addPermissions(batchForUserAndPermissionDto)){
            return new ResponseMsg<>(null,ResponseMsg.SUCCESS_CODE,ResponseMsg.SUCCESS);
        }
        return new ResponseMsg<>(null,ResponseMsg.ERROR_CODE,ResponseMsg.ERROR);
    }

}
