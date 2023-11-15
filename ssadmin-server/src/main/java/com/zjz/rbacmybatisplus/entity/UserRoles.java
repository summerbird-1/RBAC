package com.zjz.rbacmybatisplus.entity;


import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * (UserRoles)表实体类
 *
 * @author makejava
 * @since 2023-11-04 12:58:26
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user_roles")
public class UserRoles  {

    //@TableId
    private Long userid;

    //@TableId
    private Long roleid;



}
