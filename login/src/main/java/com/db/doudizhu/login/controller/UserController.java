package com.db.doudizhu.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * date: 2020/2/26 14:54
 * author: DengBiao
 */
@RestController
public class UserController {

    // 登录
    @RequestMapping("/login")
    public String login() {
        return "获取成功！";
    }

    // 验证登录
    @RequestMapping("/verifyLogin")
    public String verifyLogin() {
        return "获取成功！";
    }
}
