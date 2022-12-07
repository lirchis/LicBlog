package com.lirchis.blogapi.service.impl;

import com.lirchis.blogapi.entity.User;
import com.lirchis.blogapi.exception.LoginException;
import com.lirchis.blogapi.exception.NotFoundException;
import com.lirchis.blogapi.mapper.UserMapper;
import com.lirchis.blogapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User getUserByUsernameAndPassword(String username, String password) {

        User user = userMapper.findByUsername(username);
        if(!user.getPassword().equals(password)){
            throw new LoginException("用户名或密码错误");
        }
        return user;
    }
}
