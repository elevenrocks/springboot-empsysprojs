package org.lanqiao.empsys.controller;

import org.apache.dubbo.config.annotation.DubboReference;
import org.lanqiao.empsys.domain.User;
import org.lanqiao.empsys.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @DubboReference(interfaceClass = UserService.class,version = "1.0")
    private UserService userService;

    @GetMapping("/")
    public String index(){
        return "login";
    }

    @PostMapping("/user/login")
    public String login(User user){
        if (user==null){
            return "redirect:/";
        }
        User u = null;
        u = userService.queryUser(user);
        if (u==null){
            return "redirect:/";
        }

        return "redirect:/employees/query";
    }

}
