package com.zjz.rbacmybatisplus.utils;

import com.zjz.rbacmybatisplus.entity.Menu;
import com.zjz.rbacmybatisplus.entity.vo.MenuTreeVo;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class SystemConverter {

    private SystemConverter(){

    }
    public static List<MenuTreeVo> buildMenuSelectTree(List<Menu> menus){
        List<MenuTreeVo> menuTreeVoList = menus.stream()
                .map(m -> new MenuTreeVo(m.getId(), m.getMenuName(), m.getParentId(), null))
                .collect(Collectors.toList());
        List<MenuTreeVo> menuTreeVos = menuTreeVoList.stream()
                .filter(o -> o.getParentId().equals(0L))
                .map(o -> o.setChildren(getChildList(menuTreeVoList, o)))
                .collect(Collectors.toList());
        return menuTreeVos;

    }

    /**
     * 得到子节点列表
     */

    private static List<MenuTreeVo> getChildList(List<MenuTreeVo>list,MenuTreeVo menuTreeVo){
        List<MenuTreeVo> collect = list.stream()
                .filter(o -> Objects.equals(o.getParentId(), menuTreeVo.getId()))
                .map(o -> o.setChildren(getChildList(list, o)))
                .collect(Collectors.toList());
        return collect;
    }
}
