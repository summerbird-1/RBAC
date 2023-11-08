package com.zjz.rbacmybatisplus.entity.vo;

import lombok.Data;

@Data
public class UserVo {
    /**
     * 主键
     */
    private Long userid;
    /**
     * 用户名
     */
    private String username;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 账号状态（0正常 1停用）
     */
    private String status;
}
