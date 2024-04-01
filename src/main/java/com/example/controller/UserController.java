package com.example.controller;
import com.example.pojo.User;
import com.example.pojo.Result;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @PostMapping("/register")
    public Result register(String username, String password ){
        //查询用户
        User u = userService.findByUserName(username);
        if (u == null){
            //没有被占用
            //注册
            userService.register(username,password);
            return Result.success();
        }else{
            //用户名已经被占用
            return Result.error("用户已经被占用");
        }

    }
}
