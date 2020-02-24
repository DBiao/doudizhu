package com.db.doudizhu.login.serviceimpl;

import com.db.doudizhu.login.entity.User;
import com.db.doudizhu.login.mapper.UserMapper;
import com.db.doudizhu.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * date: 2020/2/24 17:59
 * author: DengBiao
 */
@Repository
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserByNameAndPw(User user) {
        return userMapper.getUser(user);
    }
}
