package com.zjz.rbacmybatisplus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zjz.rbacmybatisplus.entity.ResponseResult;
import com.zjz.rbacmybatisplus.entity.Role;
import com.zjz.rbacmybatisplus.entity.dto.RoleIdStatus;

import java.util.List;


/**
 * (Role)表服务接口
 *
 * @author makejava
 * @since 2023-11-04 12:28:04
 */
public interface RoleService extends IService<Role> {

    List<Role> selectRoleAll();

    List<Long> selectRoleIdByUserId(Long id);

    ResponseResult listAllRole(Role role, Integer pageNum, Integer pageSize);


    void insertRole(Role role);

    void updateRole(Role role);

}

