package com.bit.controller;

import com.bit.service.UserService;
import com.bit.utils.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Resource
    private UserService userService;


//    查询所有用户信息，测试使用
    @GetMapping("/listAll")
    public Result listAll(){
        return Result.ok(userService.list());
    }
}
