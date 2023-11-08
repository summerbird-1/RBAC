package com.zjz.rbacmybatisplus;

import com.zjz.rbacmybatisplus.entity.User;
import com.zjz.rbacmybatisplus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RbacMybatisPlusApplicationTests {

    @Autowired
    private UserMapper userMapper;
    @Test
    void MPTest() {
        User user = userMapper.selectById(2L);
        System.out.println(user);
    }

}
