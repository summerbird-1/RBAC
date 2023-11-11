package com.zjz.rbacmybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zjz.rbacmybatisplus.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


/**
 * 用户表(User)表数据库访问层
 *
 * @author makejava
 * @since 2023-11-04 11:22:01
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    Long findIdByName(String username);
}
