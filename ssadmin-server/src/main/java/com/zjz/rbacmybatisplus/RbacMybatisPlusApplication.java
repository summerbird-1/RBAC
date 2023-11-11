package com.zjz.rbacmybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zjz.rbacmybatisplus.mapper")
public class RbacMybatisPlusApplication {

    public static void main(String[] args) {
        SpringApplication.run(RbacMybatisPlusApplication.class, args);
    }

}
