package cn.lovehao.controller;

import cn.lovehao.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login(User user){
        Subject currentUser = SecurityUtils.getSubject();
        if(!currentUser.isAuthenticated()){
            UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(),user.getPassword());
            token.setRememberMe(true);
            try{
                currentUser.login(token);
            }catch (Exception e){
                System.out.println("登录失败:" + e.getMessage());
            }
        }
        return "redirect:/";
    }

}
