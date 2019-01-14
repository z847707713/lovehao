package cn.lovehao.controller;

import cn.lovehao.entity.Student;
import cn.lovehao.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TestController {

    @Autowired
    StudentService studentService;

    @RequestMapping("/test")
    @ResponseBody
    public List<Student> test(){
        return studentService.selectAll();
    }

}
