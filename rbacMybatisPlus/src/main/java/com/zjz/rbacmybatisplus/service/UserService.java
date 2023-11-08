package com.zjz.rbacmybatisplus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zjz.rbacmybatisplus.entity.ResponseResult;
import com.zjz.rbacmybatisplus.entity.User;
import com.zjz.rbacmybatisplus.entity.dto.LoginRequest;
import com.zjz.rbacmybatisplus.entity.dto.UserIdStatus;


/**
 * 用户表(User)表服务接口
 *
 * @author makejava
 * @since 2023-11-04 11:22:01
 */
public interface UserService extends IService<User> {

    ResponseResult login(LoginRequest user);

    ResponseResult selectUserPage(User user, Integer pageNum, Integer pageSize);

    boolean checkUserNameUnique(String username);

    boolean checkEmailUnique(String email);

    boolean checkPhoneUnique(String phone);

    ResponseResult addUser(User user);

    ResponseResult delUser(Long id);

    void updateUser(User user);

    ResponseResult changeStatus(UserIdStatus idStatus);

    ResponseResult getUserInfo(Long id);

    Long findIdByName(String username);
}

