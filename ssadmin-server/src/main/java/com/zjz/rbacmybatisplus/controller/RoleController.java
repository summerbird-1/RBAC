package com.zjz.rbacmybatisplus.controller;



import com.zjz.rbacmybatisplus.entity.ResponseResult;
import com.zjz.rbacmybatisplus.entity.Role;
import com.zjz.rbacmybatisplus.entity.dto.RoleIdStatus;
import com.zjz.rbacmybatisplus.service.RoleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Role)表控制层
 *
 * @author makejava
 * @since 2023-11-04 12:28:04
 */
@RestController
@RequestMapping("role")
public class RoleController{
    /**
     * 服务对象
     */
    @Resource
    private RoleService roleService;
    @GetMapping("/list")
    public ResponseResult listAllRole(Role role,Integer pageNum,Integer pageSize){

        return roleService.listAllRole(role,pageNum,pageSize);
    }

    @GetMapping("/listAllRole")
    public ResponseResult listRoleAll(){
        List<Role> roleList = roleService.selectRoleAll();
        return ResponseResult.okResult(roleList);
    }

    /**
     * 获取指定id角色信息，更新用户信息时使用
     * @param id
     * @return
     */
    @GetMapping("/getRole/{id}")
   public ResponseResult getRole(@PathVariable("id")Long id){
        Role role = roleService.getById(id);
        return ResponseResult.okResult(role);
    }

    /**
     * 更新用户信息,不能简单用更新操作，需要更新role_menu表
     * @param role
     * @return
     */
    @PutMapping
    public ResponseResult updateRole(@RequestBody Role role){
          roleService.updateRole(role);
          return ResponseResult.okResult();
    }
    @PutMapping("/changeStatus")
    public ResponseResult changeStatus(@RequestBody RoleIdStatus roleIdStatus){
        Role role = roleService.getById(roleIdStatus.getRoleId());
        role.setStatus(roleIdStatus.getStatus());
        roleService.updateById(role);
        return ResponseResult.okResult();
    }
    @PostMapping("/addRole")
    public ResponseResult addRole(@RequestBody Role role){
        roleService.insertRole(role);
        return ResponseResult.okResult();
    }

    @DeleteMapping("/delRole/{id}")
    public  ResponseResult delRole(@PathVariable("id")Long id){
        roleService.removeById(id);
        return ResponseResult.okResult();
    }


}

