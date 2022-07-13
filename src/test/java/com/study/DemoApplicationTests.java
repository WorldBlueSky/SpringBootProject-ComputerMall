package com.study;

import com.study.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@MapperScan("com..*.mapper")
@RunWith(SpringRunner.class)
class DemoApplicationTests {

    @Autowired
    private UserServiceImpl userService;

    @Test
    void contextLoads() {

    }

}
