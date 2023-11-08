package com.zjz.rbacmybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zjz.rbacmybatisplus.entity.Role;

import java.util.List;


/**
 * (Role)表数据库访问层
 *
 * @author makejava
 * @since 2023-11-04 12:28:04
 */
public interface RoleMapper extends BaseMapper<Role> {

    List<Long> selectRoleIdByUserId(Long id);

}
