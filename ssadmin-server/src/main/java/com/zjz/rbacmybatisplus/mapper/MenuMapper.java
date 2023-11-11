package com.zjz.rbacmybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zjz.rbacmybatisplus.entity.Menu;
import org.apache.ibatis.annotations.Mapper;


/**
 * 菜单权限表(Menu)表数据库访问层
 *
 * @author makejava
 * @since 2023-11-06 11:31:40
 */
@Mapper
public interface MenuMapper extends BaseMapper<Menu> {

}
