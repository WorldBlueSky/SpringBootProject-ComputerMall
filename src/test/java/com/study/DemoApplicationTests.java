package com.study;

import com.study.pojo.User;
import com.study.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@MapperScan("com..*.mapper")
class DemoApplicationTests {

    @Autowired
    private UserServiceImpl userService;

    @Test
    void contextLoads() {
        List<User> list = userService.getUsers();
        System.out.println(list);
    }

}
