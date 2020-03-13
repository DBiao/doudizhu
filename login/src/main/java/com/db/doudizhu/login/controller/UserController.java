package com.db.doudizhu.login.controller;

import com.db.doudizhu.login.entity.User;
import com.db.doudizhu.login.kit.ZKit;
import com.db.doudizhu.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * date: 2020/2/26 14:54
 * <p>
 * author: DengBiao
 */
@RestController
public class UserController {

    private UserService userService;

    @Autowired
    private ZKit zKit;

    // 登录
    @RequestMapping("/login")
    public String login() {
        String name = "null", password = "null";
        User user = new User(name, password);
        User u = userService.getUserByNameAndPw(user);
        if (u != null) {
            int result = userService.updateUserByUid(u);
            if (result == 0) {
                return "";
            }
        } else {
            int result = userService.insetUser(user);
            if (result == 0) {
                return "";
            }
        }
        String ip = zKit.selectServer();
        return ip;
    }

    // 验证登录
    @RequestMapping("/verifyLogin")
    public String verifyLogin() {
        String token = "null";
        User user = new User(token);
        User u = userService.getUserByToken(user);
        return "验证登录";
    }
}
