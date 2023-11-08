package com.zjz.rbacmybatisplus.controller;

import com.zjz.rbacmybatisplus.entity.Menu;
import com.zjz.rbacmybatisplus.entity.ResponseResult;
import com.zjz.rbacmybatisplus.entity.vo.MenuTreeVo;
import com.zjz.rbacmybatisplus.entity.vo.MenuVo;
import com.zjz.rbacmybatisplus.service.MenuService;
import com.zjz.rbacmybatisplus.utils.BeanCopyUtils;
import com.zjz.rbacmybatisplus.utils.SystemConverter;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;


/**
 * 菜单权限表(Menu)表控制层
 *
 * @author makejava
 * @since 2023-11-06 11:31:40
 */
@RestController
@RequestMapping("menu")
public class MenuController{
    /**
     * 服务对象
     */
    @Resource
    private MenuService menuService;

    @GetMapping("/list")
    public ResponseResult getMenuList(Menu menu){
        List<Menu> menus =  menuService.getMenuList(menu);
        List<MenuVo> menuVos = BeanCopyUtils.copyBeanList(menus, MenuVo.class);
        return ResponseResult.okResult(menuVos);
    }

    @GetMapping("/treeSelect")
    public ResponseResult TreeSelect(){
        List<Menu> menuList = menuService.getMenuList(new Menu());
        List<MenuTreeVo> menuTreeVos = SystemConverter.buildMenuSelectTree(menuList);
        return ResponseResult.okResult(menuTreeVos);
    }

    /**
     * 返回角色对应权限树
     * @param id
     * @return
     */
    @GetMapping("/roleMenuTreeselect/{id}")
    public ResponseResult RoleMenuTreeSelect(@PathVariable("id")Long id){
        List<Menu> menuList = menuService.getMenuList(new Menu());
        List<MenuTreeVo> menuTreeVos = SystemConverter.buildMenuSelectTree(menuList);
        return ResponseResult.okResult(menuTreeVos);
    }

    /**
     * 添加菜单信息
     * @param menu
     * @return
     */
    @PostMapping
    public ResponseResult addMenu(@RequestBody Menu menu){
        menuService.save(menu);
        return ResponseResult.okResult();
    }

    /**
     * 删除菜单，只能删除无子菜单的项
     * @param id
     * @return
     */
    @DeleteMapping("{id}")
    public ResponseResult delMenu(@PathVariable("id")Long id){
        if(menuService.hasChildren(id))
        {
            return  ResponseResult.errorResult(400,"拥有子菜单不可删除");
        }
        menuService.removeById(id);
        return ResponseResult.okResult();
    }

    /**
     * 获取某个菜单信息
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public ResponseResult getMenu(@PathVariable("id")Long id){
        Menu menu = menuService.getById(id);
        return ResponseResult.okResult(menu);
    }

    /**
     * 更新菜单信息
     * @param menu
     * @return
     */
    @PutMapping
    public ResponseResult updateMenu(@RequestBody Menu menu){
        menuService.updateById(menu);
        return ResponseResult.okResult();
    }
}

