package com.db.doudizhu.login.controller;

import com.db.doudizhu.login.entity.User;
import com.db.doudizhu.login.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * date: 2020/2/26 14:54
 * author: DengBiao
 */
@RestController
public class UserController {

    private UserService userService;

    // 登录
    @RequestMapping("/login")
    public String login() {
        String name = null, password = null;
        User user = new User(name, password);
        User u = userService.getUserByNameAndPw(user);
        return "登录";
    }

    // 验证登录
    @RequestMapping("/verifyLogin")
    public String verifyLogin() {
        return "验证登录";
    }
}
