package com.zjz.rbacmybatisplus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zjz.rbacmybatisplus.entity.RoleMenu;


/**
 * 角色和菜单关联表(RoleMenu)表服务接口
 *
 * @author makejava
 * @since 2023-11-06 11:32:04
 */
public interface RoleMenuService extends IService<RoleMenu> {

    void deleteRoleMenuByRoleId(Long roleid);
}

