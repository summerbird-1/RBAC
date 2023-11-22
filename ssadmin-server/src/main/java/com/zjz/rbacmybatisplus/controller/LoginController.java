package com.zjz.rbacmybatisplus.controller;

import com.zjz.rbacmybatisplus.entity.ResponseResult;
import com.zjz.rbacmybatisplus.entity.User;
import com.zjz.rbacmybatisplus.entity.dto.LoginRequest;
import com.zjz.rbacmybatisplus.enums.AppHttpCodeEnum;
import com.zjz.rbacmybatisplus.exception.SystemException;
import com.zjz.rbacmybatisplus.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;
    @PostMapping("/login")
    public ResponseResult login(@RequestBody LoginRequest user){
        if(!StringUtils.hasText(user.getUsername())){
            throw new SystemException(AppHttpCodeEnum.USERNAME_NOT_NULL);
        }
        return  loginService.login(user);

    }
    @PostMapping("/logout")
    public ResponseResult logout(){

        return loginService.logout();

    }


}
