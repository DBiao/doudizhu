package com.db.doudizhu.login.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * date: 2020/2/24 17:21
 * author: DengBiao
 */

@Data
public class User {
    private Integer uid;
    private String token;
    private String name;
    private String password;

    public User() {
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public User(Integer uid, String token, String name, String password) {
        this.uid = uid;
        this.token = token;
        this.name = name;
        this.password = password;
    }
}
