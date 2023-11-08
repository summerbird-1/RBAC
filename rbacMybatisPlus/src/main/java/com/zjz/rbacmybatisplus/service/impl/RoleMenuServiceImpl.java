package com.zjz.rbacmybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zjz.rbacmybatisplus.entity.RoleMenu;
import com.zjz.rbacmybatisplus.mapper.RoleMenuMapper;
import com.zjz.rbacmybatisplus.service.RoleMenuService;
import org.springframework.stereotype.Service;

import javax.security.auth.callback.LanguageCallback;

/**
 * 角色和菜单关联表(RoleMenu)表服务实现类
 *
 * @author makejava
 * @since 2023-11-06 11:32:04
 */
@Service("roleMenuService")
public class RoleMenuServiceImpl extends ServiceImpl<RoleMenuMapper, RoleMenu> implements RoleMenuService {

    @Override
    public void deleteRoleMenuByRoleId(Long roleid) {
        LambdaQueryWrapper<RoleMenu> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(RoleMenu::getRoleId,roleid);
        remove(queryWrapper);
    }
}

