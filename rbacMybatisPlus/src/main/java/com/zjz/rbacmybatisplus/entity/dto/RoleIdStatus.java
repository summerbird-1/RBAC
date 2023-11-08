package com.zjz.rbacmybatisplus.entity.dto;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
public class RoleIdStatus {
    private Long roleId;
    private String status;
}
