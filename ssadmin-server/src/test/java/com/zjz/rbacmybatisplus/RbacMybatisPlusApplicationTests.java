package com.zjz.rbacmybatisplus;

import com.zjz.rbacmybatisplus.entity.User;
import com.zjz.rbacmybatisplus.mapper.UserMapper;
import com.zjz.rbacmybatisplus.utils.JwtUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class RbacMybatisPlusApplicationTests {

    @Autowired
    private UserMapper userMapper;
    @Test
    void MPTest() {
        User user = userMapper.selectById(2L);
        System.out.println(user);
    }
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Test
    void test(){
        String password = bCryptPasswordEncoder.encode("1234");
        System.out.println(password);
    }
}
