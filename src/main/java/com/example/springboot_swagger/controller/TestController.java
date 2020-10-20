package com.example.springboot_swagger.controller;

import com.example.springboot_swagger.pojo.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test")
    public String test(){
        return "hello swagger";
    }

    @GetMapping("/hello/1")
    public String test2(){
        return "hello world!";
    }

    @PostMapping("/user")
    public User getUser(){  //只要接口中,返回值存在实体类, 它就会被扫描到swagger中
        return new User();
    }
}
