package com.chen.mapper;

import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    // 根据用户名获取密码
    String getPwd(String username);
}
