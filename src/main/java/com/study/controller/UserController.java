package com.study.controller;

import com.study.pojo.User;
import com.study.service.IUserService;
import com.study.service.ex.InsertException;
import com.study.service.ex.UsernameDuplicatedException;
import com.study.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController extends BaseController{

    @Autowired
    private IUserService userService;


    /**
     *
     * 请求的路径 users/reg
     * 这是接收注册的请求 User user
     * 响应结果 JsonResult<void>
     */
    @RequestMapping("/reg")
    public JsonResult<Void> reg(User user){

        JsonResult<Void> result = new JsonResult<>();
        userService.register(user);

        result.setState(200);
        result.setMessage("用户注册成功!");
        return result;
    }


}
