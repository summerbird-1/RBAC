package com.zjz.rbacmybatisplus.controller;




import com.zjz.rbacmybatisplus.entity.ResponseResult;
import com.zjz.rbacmybatisplus.entity.Role;
import com.zjz.rbacmybatisplus.entity.User;
import com.zjz.rbacmybatisplus.entity.dto.LoginRequest;
import com.zjz.rbacmybatisplus.entity.dto.UserIdStatus;
import com.zjz.rbacmybatisplus.entity.vo.UserInfoAndRoleIdsVo;
import com.zjz.rbacmybatisplus.enums.AppHttpCodeEnum;
import com.zjz.rbacmybatisplus.exception.SystemException;
import com.zjz.rbacmybatisplus.mapper.UserMapper;
import com.zjz.rbacmybatisplus.service.RoleService;
import com.zjz.rbacmybatisplus.service.UserService;

import com.zjz.rbacmybatisplus.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


/**
 * 用户表(User)表控制层
 *
 * @author makejava
 * @since 2023-11-04 11:22:00
 */
@RestController
@RequestMapping("user")
public class UserController{
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;


    @PostMapping("/login")
    public ResponseResult login(@RequestBody LoginRequest user){

        return userService.login(user);
    }

    @GetMapping("/getInfo")
    public ResponseResult getInfo(@RequestHeader("Authorization") String authHeader){
        // 解析Authorization请求头中的JWT令牌 Bearer access_token
        String token = authHeader.substring(7);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        //User foundUser = userService.findByname(username);
        Long idByName = userService.findIdByName(username);

        return new ResponseResult(200,"查询成功",username);

    }
    /**
     * 获取用户列表
     * @param user
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/list")
    public ResponseResult list(User user, Integer pageNum, Integer pageSize){
        return userService.selectUserPage(user,pageNum,pageSize);
    }

    @PostMapping
    public ResponseResult addUser(@RequestBody User user){
        if(!StringUtils.hasText(user.getUsername())){
            throw new SystemException(AppHttpCodeEnum.REQUIRE_USERNAME);
        }
        if(!userService.checkUserNameUnique(user.getUsername())){
            throw new SystemException(AppHttpCodeEnum.USERNAME_EXIST);
        }
        if(!userService.checkEmailUnique(user.getEmail())){
            throw new SystemException(AppHttpCodeEnum.EMAIL_EXIST);
        }
        if(!userService.checkPhoneUnique(user.getPhone())){
            throw new SystemException(AppHttpCodeEnum.PHONENUMBER_EXIST);
        }
        return userService.addUser(user);
    }

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    @PutMapping
    public ResponseResult updateUser(@RequestBody User user){
        userService.updateUser(user);
        return ResponseResult.okResult();
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseResult delUser(@PathVariable Long id){
        return userService.delUser(id);
    }

    /**
     * 获取指定id用户的信息，所有角色信息，绑定的角色id
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseResult getUserInfo(@PathVariable Long id){
       return userService.getUserInfo(id);
    }

    /**
     *改变用户状态
     * @param idStatus
     * @return
     */
    @PutMapping("/changeStatus")
    public ResponseResult changeStatus(@RequestBody UserIdStatus idStatus){
        return userService.changeStatus(idStatus);
    }
}

