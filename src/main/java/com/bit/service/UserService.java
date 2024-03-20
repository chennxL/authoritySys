package com.bit.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bit.entity.User;

public interface UserService extends IService<User> {
//   根据用户名查询用户信息
    User findUserByUserName(String username);
}
