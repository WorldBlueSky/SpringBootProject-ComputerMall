package com.study.controller;

import com.study.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping("/hello")
    public String getUser(){
        return userService.getUsers().toString();
    }
}
