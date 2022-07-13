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

    void register(User user) throws UsernameDuplicatedException, InsertException; //register注册方法



}
