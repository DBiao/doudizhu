package com.db.doudizhu.login.service;

import com.db.doudizhu.login.entity.User;
import org.springframework.stereotype.Service;

/**
 * date: 2020/2/24 17:57
 * author: DengBiao
 */

@Service
public interface UserService {
    User getUserByNameAndPw(User user);

    int updateUserByUid(User user);

    int insetUser(User user);
}
