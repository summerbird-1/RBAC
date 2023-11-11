package com.zjz.rbacmybatisplus.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserIdStatus {
    private Long userId;
    private String Status;
}
