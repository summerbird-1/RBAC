package com.zjz.rbacmybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

import com.zjz.rbacmybatisplus.constants.SystemConstants;
import com.zjz.rbacmybatisplus.entity.LoginUser;
import com.zjz.rbacmybatisplus.entity.User;
import com.zjz.rbacmybatisplus.mapper.MenuMapper;
import com.zjz.rbacmybatisplus.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MenuMapper menuMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //根据用户名查询用户信息
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUsername,username);           //查询条件
        User user = userMapper.selectOne(queryWrapper);
        //判断是否查到用户。没查到抛出异常
        if(Objects.isNull(user)){
            throw new RuntimeException("用户不存在");
        }
        //返回用户信息
        //TODO 查询权限信息封装
        //TODO 如果是后台用户需要查询权限封装

            List<String> list = menuMapper.selectPermsByUserId(user.getUserid());
            return new LoginUser(user,list);

       // return new LoginUser(user,null);
    }
}
