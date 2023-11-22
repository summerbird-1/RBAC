package com.zjz.rbacmybatisplus.utils;


import com.zjz.rbacmybatisplus.entity.LoginUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtils
{

    /**
     * 获取用户
     **/
    public static LoginUser getLoginUser()
    {
        LoginUser loginUser = (LoginUser) getAuthentication().getPrincipal();
        return loginUser;
    }

    /**
     * 获取Authentication
     */
    public static Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    public static Boolean isAdmin(){
        Long id = getLoginUser().getUser().getUserid();
        return id != null && id.equals(1L);
    }

    public static Long getUserId() {

        return getLoginUser().getUser().getUserid();
    }
}