package com.db.doudizhu.login.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * date: 2020/2/24 17:21
 * author: DengBiao
 */

@Data
@Component
public class User {
    private Integer uid;
    private String name;
    private String password;

    public User() {
    }

    public User(Integer uid, String name, String password) {
        this.uid = uid;
        this.name = name;
        this.password = password;
    }
}
