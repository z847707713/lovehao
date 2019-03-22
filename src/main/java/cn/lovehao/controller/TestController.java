package cn.lovehao.controller;

import cn.lovehao.Utils.CommonUtils;
import cn.lovehao.dto.EditUploadDto;
import cn.lovehao.entity.Permission;
import cn.lovehao.service.PermissionService;
import cn.lovehao.service.UploadService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

@Controller
public class TestController {

    @Autowired
    PermissionService permissionService;



    @RequestMapping("/permission")
    @ResponseBody
    public List<Permission> permission(Permission permission){
        return permissionService.getAll(permission);
    }




    @RequestMapping("/test")
    public String test(HttpServletRequest req, HttpServletResponse resp){
       return "test";
    }

    @ResponseBody
    @RequestMapping(value = "/test",method = RequestMethod.POST)
    public String headerTest(HttpServletRequest request){
        System.out.println(request.getHeader("token"));
        return "true";
    }


}
