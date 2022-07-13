package com.study.service.impl;

import com.study.mapper.UserMapper;
import com.study.pojo.User;
import com.study.service.IUserService;
import com.study.service.ex.InsertException;
import com.study.service.ex.UsernameDuplicatedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.UUID;

/**
 * 用户模块业务层的实现类
 */

@Service
public class UserServiceImpl implements IUserService {

   @Autowired(required = false)
   private UserMapper userMapper;

    @Override
    public void register(User user){

        // 通过user参数获取传递过来的name
        String name = user.getUsername();

        // 调用userMapper 的 selectByName，判断用户名是否已存在
        User result  = userMapper.selectByName(name);

        // 判断结果集是否为null

        // 如果不为null，那么抛出用户名被占用的异常
        if(result!=null){
            throw new  UsernameDuplicatedException("用户名已被注册!");
        }

        // 如果用户名没问题，那么继续补充用户的其他相关信息
        user.setIsDelete(0); //是否注销，不注销

        // 密码加密处理的实现 md5算法的形式
        // 乱串 + password + 串 ----md5算法进行加密，整体连续加载三次
        // 串 称为—盐值-一个随机的字符串而已

       String oldPassword = user.getPassword();

       // 获取盐值（随机生成一个盐值（随机字符串））
        String salt = UUID.randomUUID().toString().toUpperCase();
      // 获取加密之后的密码
        String md5Password = getMd5Password(oldPassword,salt);
       // 补充密码相关信息
         user.setSalt(salt); // 盐值一定要记录，登陆的时候进行加密与数据库进行比对
         user.setPassword(md5Password); // 这种方式可以忽略用户设置密码的强度

        // 补充用户操作的日志信息

        user.setCreatedUser(user.getUsername());
        Date date = new Date();
        user.setCreatedTime(date); // 创建时的时间
        user.setModifiedUser(user.getUsername()); // 修改人的信息
        user.setModifiedTime(date); // 修改用户信息的时间

        //如果为null，那么继续注册
        Integer rows = userMapper.insert(user);

        //如果正在执行insert的时候服务器宕机了，那么插入失败
        if(rows!=1){
            throw new InsertException("在注册过程中产生了未知的异常");
        }
    }

    /**
     * 用来对密码进行三次加密
     * @param password 用户传递的原密码
     * @param salt    随机生成的盐值
     * @return 返回加密之后的密码
     */
    private String getMd5Password(String password,String salt){
        // springBoot提供了一个加密工具类 DigestUtils

        for(int i = 0;i<3;i++){
            password = DigestUtils.md5DigestAsHex((salt+password+salt).getBytes()).toUpperCase();
        }

        // 返回加密之后的密码
        return password;

    }
}
