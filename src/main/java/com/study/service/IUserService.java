package com.study.service;

import com.study.pojo.User;
import com.study.service.ex.InsertException;
import com.study.service.ex.UsernameDuplicatedException;

import java.util.List;


/**
 * 设计 接口,通常以I开头
 * 用户模块业务层接口
 */
public interface IUserService {

    /**
     * 用户注册方法
     * @param user 用户的数据对象
     */

    void register(User user); //register注册方法

    /**
     * 用户登陆功能
     * @param username 用户名
     * @param password 用户密码
     * @return 当前匹配的用户数据，如果没有则返回null值
     */

    User login(String username,String password);

}
