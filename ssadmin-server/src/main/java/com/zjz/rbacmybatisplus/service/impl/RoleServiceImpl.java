package com.zjz.rbacmybatisplus.service.impl;



import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zjz.rbacmybatisplus.constants.SystemConstants;
import com.zjz.rbacmybatisplus.entity.*;
import com.zjz.rbacmybatisplus.entity.dto.RoleIdStatus;
import com.zjz.rbacmybatisplus.entity.vo.PageVo;
import com.zjz.rbacmybatisplus.mapper.RoleMapper;
import com.zjz.rbacmybatisplus.service.RoleMenuService;
import com.zjz.rbacmybatisplus.service.RoleService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * (Role)表服务实现类
 *
 * @author makejava
 * @since 2023-11-04 12:28:04
 */
@Service("roleService")
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    @Autowired
    private RoleMenuService roleMenuService;

    @Override
    public List<Role> selectRoleAll() {
        LambdaQueryWrapper<Role> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Role::getStatus, SystemConstants.STATUS_NORMAL);
        List<Role> list = list(queryWrapper);
        return list;
    }

    @Override
    public List<Long> selectRoleIdByUserId(Long id) {
        return getBaseMapper().selectRoleIdByUserId(id);
    }

    @Override
    public ResponseResult listAllRole(Role role, Integer pageNum, Integer pageSize) {
        LambdaQueryWrapper<Role> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(StringUtils.hasText(role.getRolename()),Role::getRolename,role.getRolename());
        queryWrapper.eq(StringUtils.hasText(role.getStatus()),Role::getStatus,role.getStatus());
        Page<Role> page = new Page<>();
        page.setCurrent(pageNum);
        page.setSize(pageSize);
        page(page,queryWrapper);

        //转换为vo
        List<Role> roles = page.getRecords();
        PageVo pageVo = new PageVo();
        pageVo.setRows(roles);
        pageVo.setTotal(page.getTotal());

        return ResponseResult.okResult(pageVo);

    }

    @Override
    public void insertRole(Role role) {
        save(role);
        if(role.getMenuIds()!=null &&role.getMenuIds().length > 0){
            insertRoleMenu(role);
        }
    }

    @Override
    public void updateRole(Role role) {
        updateById(role);
        roleMenuService.deleteRoleMenuByRoleId(role.getRoleid());
        insertRoleMenu(role);
    }

    /**
     * 向Role_menu表中插入数据
     * @param role
     */
    private void insertRoleMenu(Role role) {

        List<RoleMenu> collect = Arrays.stream(role.getMenuIds())
                .map(menuId -> new RoleMenu(role.getRoleid(), menuId))
                .collect(Collectors.toList());
        roleMenuService.saveBatch(collect);

    }


}

