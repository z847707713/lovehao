package cn.lovehao.controller.admin;

import cn.lovehao.dto.ResponseMsg;
import cn.lovehao.dto.BatchForUserAndPermissionDto;
import cn.lovehao.entity.ZTreeData;
import cn.lovehao.service.RoleService;
import cn.lovehao.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/userRole")
public class UserRoleController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserRoleService userRoleService;


    @RequestMapping("/view/{id}")
    public String view(@PathVariable Integer id, Map<String,Object> map){
        map.put("id",id);
        return "/admin/userRole";
    }

    @ResponseBody
    @RequestMapping("/tree")
    public List<ZTreeData> getTree(Integer roleId){
        return roleService.getZTreeDataByRoleId(roleId);
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public ResponseMsg<String> distPermissions(@RequestBody BatchForUserAndPermissionDto batchForUserAndPermissionDto){

        try{
            userRoleService.distRoles(batchForUserAndPermissionDto);
            return new ResponseMsg<>(null,ResponseMsg.SUCCESS_CODE,ResponseMsg.SUCCESS);
        } catch (Exception e){
            return new ResponseMsg<>(null,ResponseMsg.ERROR_CODE,ResponseMsg.ERROR);
        }
    }

}


