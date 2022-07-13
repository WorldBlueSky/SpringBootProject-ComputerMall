package com.study.serviceTest;


import com.study.pojo.User;
import com.study.service.IUserService;
import com.study.service.ex.InsertException;
import com.study.service.ex.UsernameDuplicatedException;
import com.study.service.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTest {

    @Autowired
    private IUserService userService;

    /**
     * 调用测试方法，测试注册的方法是否正常
     * @throws InsertException
     * @throws UsernameDuplicatedException
     */

    @Test
    public void register() throws InsertException, UsernameDuplicatedException {
            User user = new User();
            user.setUsername("1111");
            user.setPassword("1111");
            userService.register(user);
            System.out.println("ok");
    }
}
