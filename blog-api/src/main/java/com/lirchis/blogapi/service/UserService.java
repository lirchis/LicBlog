package com.lirchis.blogapi.service;


import com.lirchis.blogapi.entity.User;


public interface UserService {
    User getUserByUsernameAndPassword(String username,String password);
}
