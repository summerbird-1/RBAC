package com.zjz.rbacmybatisplus.entity.dto;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}
