package com.zjz.rbacmybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zjz.rbacmybatisplus.entity.UserRoles;
import com.zjz.rbacmybatisplus.mapper.UserRolesMapper;
import com.zjz.rbacmybatisplus.service.UserRolesService;
import org.springframework.stereotype.Service;

/**
 * (UserRoles)表服务实现类
 *
 * @author makejava
 * @since 2023-11-04 12:58:26
 */
@Service("userRolesService")
public class UserRolesServiceImpl extends ServiceImpl<UserRolesMapper, UserRoles> implements UserRolesService {

}

