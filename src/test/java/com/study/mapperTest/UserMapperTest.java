package com.study.mapperTest;


import com.study.mapper.UserMapper;
import com.study.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;


@SpringBootTest
@RunWith(SpringRunner.class)
public class UserMapperTest {

    @Resource
    private UserMapper userMapper;

    @Autowired
    private DataSource dataSource;


    @Test
    public void insert(){
        User user = new User();
        user.setUsername("admin");
        user.setPassword("admin");

        Integer ret = userMapper.insert(user);
        if(ret==1){
            System.out.println("增加成功!");
        }else{
            System.out.println("增加失败!");
        }
    }

    @Test
    public void selectAll(){
        List<User> list = userMapper.selectAll();
        for (User user :list) {
            System.out.println(user);
        }
    }

    @Test
    public void selectByName(){
        User user = userMapper.selectByName("java");
        System.out.println(user);
    }

    @Test
    public void delete(){
        Integer ret = userMapper.delete(1);
        if(ret==1){
            System.out.println("删除成功!");
        }else{
            System.out.println("删除失败!");
        }
    }

}
