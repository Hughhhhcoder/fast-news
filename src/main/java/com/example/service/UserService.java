package com.example.service;

import com.example.pojo.User;

public interface UserService {

    //用户名查询
    User findByUserName(String username);

    //用户注册
    void register(String username, String password);
}
