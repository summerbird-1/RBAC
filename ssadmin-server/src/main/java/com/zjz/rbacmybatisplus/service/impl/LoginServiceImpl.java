package com.zjz.rbacmybatisplus.service.impl;

import com.zjz.rbacmybatisplus.entity.LoginUser;
import com.zjz.rbacmybatisplus.entity.ResponseResult;
import com.zjz.rbacmybatisplus.entity.dto.LoginRequest;
import com.zjz.rbacmybatisplus.service.LoginService;
import com.zjz.rbacmybatisplus.utils.JwtUtil;
import com.zjz.rbacmybatisplus.utils.RedisCache;
import com.zjz.rbacmybatisplus.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private RedisCache redisCache;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Override
    public ResponseResult login(LoginRequest user) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        //判断是否认证通过
        if(Objects.isNull(authenticate)){
            throw new RuntimeException("用户名或密码错误");
        }
        //获取userid 生成token
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        String userId = loginUser.getUser().getUserid().toString();
        String jwt = jwtUtil.createJWT(userId);
        //把用户信息存入redis
        redisCache.setCacheObject("login:"+userId,loginUser);

        //把token封装 返回
        Map<String,String> map = new HashMap<>();
        map.put("accessToken",jwt);
        return ResponseResult.okResult(map);
    }

    @Override
    public ResponseResult logout() {
        //获取当前登录的用户id
        Long userId = SecurityUtils.getUserId();
        //删除redis中对应的值
        redisCache.deleteObject("login:"+userId);

        return ResponseResult.okResult();
    }

//    @Override
//    public ResponseResult refreshToken(String token) {
//        if(jwtTokenUtil.validateToken(token)){
//            String username = jwtTokenUtil.getUsernameFromToken(token);
//            String refreshToken = jwtTokenUtil.generateRefreshToken(username);
//            String accessToken = jwtTokenUtil.generateAccessToken(username);
//            redisTemplate.opsForValue().set(refreshToken,username);
//            redisTemplate.opsForValue().set(accessToken,username);
//            TokenResponse token_resp = new TokenResponse(accessToken,refreshToken);
//            return new ResponseResult(200,"刷新成功",token_resp);
//        }
//        else
//            return new ResponseResult(400,"刷新失败");
//    }
}
