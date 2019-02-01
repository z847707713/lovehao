package cn.lovehao.controller.admin;

import cn.lovehao.dto.Page;
import cn.lovehao.dto.ResponseMsg;
import cn.lovehao.dto.RoleDto;
import cn.lovehao.entity.Role;
import cn.lovehao.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

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


    @RequestMapping(value = "/role/{id}",method = RequestMethod.GET)
    public String get(@PathVariable("id")Integer id, Map<String,Object> map){
        map.put("role",roleService.getRoleById(id));
        return "admin/role";
    }

    @RequestMapping(value = "/role",method = RequestMethod.GET)
    public String addView(){
        return "admin/role";
    }

    /**
     * 新增
     * @param role
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/role",method = RequestMethod.POST)
    public ResponseMsg<Role> add(Role role){
        if(roleService.addRole(role)){
            return new ResponseMsg<Role>(null,ResponseMsg.SUCCESS_CODE,ResponseMsg.SUCCESS);
        }
        return new ResponseMsg<Role>(null,ResponseMsg.ERROR_CODE,ResponseMsg.ERROR);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/role/{id}",method = RequestMethod.DELETE)
    public ResponseMsg<Role> delete(@PathVariable("id")Integer id){
        if(roleService.deleteById(id)){
            return new ResponseMsg<Role>(null,ResponseMsg.SUCCESS_CODE,ResponseMsg.SUCCESS);
        }
        return  new ResponseMsg<Role>(null,ResponseMsg.ERROR_CODE,ResponseMsg.ERROR);
    }

    /**
     * 修改
     * @param role
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/role",method = RequestMethod.PUT)
    public ResponseMsg<Role> update(Role role){
        if(roleService.updateById(role)){
            return new ResponseMsg<Role>(null,ResponseMsg.SUCCESS_CODE,ResponseMsg.SUCCESS);
        }
        return  new ResponseMsg<Role>(null,ResponseMsg.ERROR_CODE,ResponseMsg.ERROR);
    }


}
