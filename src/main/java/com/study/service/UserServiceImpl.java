package com.study.service;

import com.study.mapper.UserMapper;
import com.study.pojo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Resource
    private UserMapper userMapper;

    public List<User> getUsers(){
        List<User> list = userMapper.getUsers();
        return list;
    }

}
