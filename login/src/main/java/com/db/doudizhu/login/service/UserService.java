package com.db.doudizhu.login.service;

import com.db.doudizhu.login.entity.User;

/**
 * date: 2020/2/24 17:57
 * author: DengBiao
 */
public interface UserService {
    User getUserByNameAndPw(User user);
}
