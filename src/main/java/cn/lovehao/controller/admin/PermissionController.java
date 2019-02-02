package cn.lovehao.controller.admin;

import cn.lovehao.dto.Page;
import cn.lovehao.dto.PermissionDto;
import cn.lovehao.dto.ResponseMsg;
import cn.lovehao.entity.Permission;
import cn.lovehao.entity.Role;
import cn.lovehao.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class PermissionController {

    //添加与编辑页面
    private static final String ADD_EDIT_VIEW = "admin/permission";
    //列表页面
    private static final String LIST_VIEW = "admin/permissions";


    @Autowired
    PermissionService permissionService;

    @RequestMapping(value = "/permissions",method = RequestMethod.GET)
    public String init(){
        return LIST_VIEW;
    }

    @ResponseBody
    @RequestMapping(value = "/permission/list",method = RequestMethod.POST)
    public Page<Permission> list(PermissionDto permissionDto){
        return permissionService.getPermissionPages(permissionDto);
    }

    /**
     * 新增
     * @param permission
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/permission",method = RequestMethod.POST)
    public ResponseMsg<Permission> add(Permission permission){
        if(permissionService.addPermission(permission)){
            return new ResponseMsg<>(null,ResponseMsg.SUCCESS_CODE,ResponseMsg.SUCCESS);
        }
        return new ResponseMsg<>(null,ResponseMsg.ERROR_CODE,ResponseMsg.ERROR);
    }


    /**
     * 修改
     * @param permission
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/permission",method = RequestMethod.PUT)
    public ResponseMsg<Permission> update(Permission permission){
        if(permissionService.updateById(permission)){
            return new ResponseMsg<>(null,ResponseMsg.SUCCESS_CODE,ResponseMsg.SUCCESS);
        }
        return new ResponseMsg<>(null,ResponseMsg.ERROR_CODE,ResponseMsg.ERROR);
    }

    /**
     * 删除
     * @param permission
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/permission",method = RequestMethod.DELETE)
    public ResponseMsg<Permission> delete(Permission permission){
        if(permissionService.deleteById(permission)){
            return new ResponseMsg<>(null,ResponseMsg.SUCCESS_CODE,ResponseMsg.SUCCESS);
        }
        return new ResponseMsg<>(null,ResponseMsg.ERROR_CODE,ResponseMsg.ERROR);
    }

    /**
     * 添加页面
     * @return
     */
    @RequestMapping(value = "/permission",method = RequestMethod.GET)
    public String addView(){
        return ADD_EDIT_VIEW;
    }

    /**
     * 修改页面
     * @param id
     * @param map
     * @return
     */
    @RequestMapping(value = "/permission/{id}",method = RequestMethod.GET)
    public String editView(@PathVariable Integer id, Map<String,Object> map){
        map.put("permission",permissionService.getPermissionById(id));
        return ADD_EDIT_VIEW;
    }


}
