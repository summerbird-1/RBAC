package com.zjz.rbacmybatisplus.entity.vo;

import com.zjz.rbacmybatisplus.entity.Role;
import com.zjz.rbacmybatisplus.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoAndRoleIdsVo {
    private User user;
    private List<Role> roles;
    private List<Long> roleIds;
}
