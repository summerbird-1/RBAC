package com.zjz.rbacmybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zjz.rbacmybatisplus.entity.ResponseResult;
import com.zjz.rbacmybatisplus.entity.Role;
import com.zjz.rbacmybatisplus.entity.User;
import com.zjz.rbacmybatisplus.entity.UserRoles;
import com.zjz.rbacmybatisplus.entity.dto.UserIdStatus;
import com.zjz.rbacmybatisplus.entity.vo.PageVo;
import com.zjz.rbacmybatisplus.entity.vo.UserInfoAndRoleIdsVo;
import com.zjz.rbacmybatisplus.entity.vo.UserVo;
import com.zjz.rbacmybatisplus.mapper.UserMapper;
import com.zjz.rbacmybatisplus.service.RoleService;
import com.zjz.rbacmybatisplus.service.UserRolesService;
import com.zjz.rbacmybatisplus.service.UserService;
import com.zjz.rbacmybatisplus.utils.BeanCopyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 用户表(User)表服务实现类
 *
 * @author makejava
 * @since 2023-11-04 11:22:01
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {


    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;
    @Override
    public ResponseResult selectUserPage(User user, Integer pageNum, Integer pageSize) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(StringUtils.hasText(user.getUsername()),User::getUsername,user.getUsername());
        queryWrapper.eq(StringUtils.hasText(user.getStatus()),User::getStatus,user.getStatus());
        queryWrapper.eq(StringUtils.hasText(user.getPhone()),User::getPhone,user.getPhone());

        Page<User> page = new Page<>();
        page.setCurrent(pageNum);
        page.setSize(pageSize);
        page(page,queryWrapper);
        //封装Vo
        List<User> users = page.getRecords();
        List<UserVo> userVos = users.stream()
                .map(u -> BeanCopyUtils.copyBean(u, UserVo.class))
                .collect(Collectors.toList());

        PageVo pageVo = new PageVo();
        pageVo.setRows(userVos);
        pageVo.setTotal(page.getTotal());
        return ResponseResult.okResult(pageVo);
    }

    @Override
    public boolean checkUserNameUnique(String username) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUsername,username);
        return count(queryWrapper)==0;
    }

    @Override
    public boolean checkEmailUnique(String email) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getEmail,email);
        return count(queryWrapper)==0;
    }

    @Override
    public boolean checkPhoneUnique(String phone) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getPhone,phone);
        return count(queryWrapper)==0;
    }

    @Override
    public ResponseResult addUser(User user) {
        save(user);

        if(user.getRoleIds() != null&&user.getRoleIds().length>0){
            insertUserRole(user);
        }

        return ResponseResult.okResult();
    }

    @Override
    public ResponseResult delUser(Long id) {
        userMapper.deleteById(id);
        return ResponseResult.okResult();
    }

    @Override
    @Transactional
    public void updateUser(User user) {

        //删除用户角色关联
        LambdaQueryWrapper<UserRoles> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(UserRoles::getUserid,user.getUserid());
        userRoleService.remove(queryWrapper);
        //新增用户角色
        insertUserRole(user);
        //更新用户信息
        updateById(user);
    }

    @Override
    public ResponseResult changeStatus(UserIdStatus idStatus) {
        User user = userService.getById(idStatus.getUserId());
        List<Long> roleIds = roleService.selectRoleIdByUserId(idStatus.getUserId());
        Long[] LongRoleIds = roleIds.stream()
                .toArray(Long[]::new);
        user.setRoleIds(LongRoleIds);
        user.setStatus(idStatus.getStatus());
        userService.updateUser(user);
        return ResponseResult.okResult();
    }

    @Override
    public ResponseResult getUserInfo(Long id) {
        List<Role> roles = roleService.selectRoleAll();
        User user = userService.getById(id);
        List<Long> roleIds = roleService.selectRoleIdByUserId(id);
        UserInfoAndRoleIdsVo userInfoAndRoleIdsVo = new UserInfoAndRoleIdsVo(user,roles,roleIds);
        return ResponseResult.okResult(userInfoAndRoleIdsVo);
    }

    @Override
    public String findNameById(long id) {

            User user = userMapper.selectById(id);
            return user.getUsername();
    }



    @Autowired
    private UserRolesService userRoleService;
    private void insertUserRole(User user) {
        List<UserRoles> userRoles = Arrays.stream(user.getRoleIds()).
                map(roleId -> new UserRoles(user.getUserid(), roleId))
                .collect(Collectors.toList());
        userRoleService.saveBatch(userRoles);
    }

}

