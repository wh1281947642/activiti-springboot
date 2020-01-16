package com.yawn.controller;

import com.yawn.entity.ResponseEntity;
import com.yawn.entity.User;
import com.yawn.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @author Created by yawn on 2018-01-08 13:39
 */
@Controller
public class LoginController {

    @Resource
    private UserService userService;

    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity login(HttpSession session, @RequestBody User user) {
        String userName = user.getUserName();
        String password = user.getPassword();
        boolean login = userService.login(userName, password);
        if (login) {
            session.setAttribute("userName", userName);
            return  new ResponseEntity("登录成功",200,user);
        }
        return new ResponseEntity("登录失败",500,null);
    }

    @GetMapping("/exit")
    public String exit(HttpSession session) {
        session.removeAttribute("userName");
        return "login";
    }
}
