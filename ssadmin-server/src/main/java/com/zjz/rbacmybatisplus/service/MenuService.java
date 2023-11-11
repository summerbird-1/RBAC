package com.zjz.rbacmybatisplus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zjz.rbacmybatisplus.entity.Menu;

import java.util.List;


/**
 * 菜单权限表(Menu)表服务接口
 *
 * @author makejava
 * @since 2023-11-06 11:31:40
 */
public interface MenuService extends IService<Menu> {

    List<Menu> getMenuList(Menu menu);


    void delMenu(Long id);

    boolean hasChildren(Long id);
}

