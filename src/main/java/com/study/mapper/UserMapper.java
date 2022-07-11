package com.study.mapper;
import com.study.pojo.User;

import java.util.List;

// 不加@Mapper 注解
public interface UserMapper {
    List<User> getUsers();
}
