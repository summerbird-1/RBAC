package com.zjz.rbacmybatisplus.service;

import com.zjz.rbacmybatisplus.entity.ResponseResult;
import com.zjz.rbacmybatisplus.entity.dto.LoginRequest;

public interface LoginService {
    ResponseResult login(LoginRequest user);

    ResponseResult logout();

//    ResponseResult refreshToken(String token);
}
