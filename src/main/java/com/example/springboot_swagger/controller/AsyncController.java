package com.example.springboot_swagger.controller;

import com.example.springboot_swagger.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AsyncController {

    @Autowired
    private AsyncService asyncService;

    @GetMapping("/async/hello")
    public String hello(){
        asyncService.hello();
        return "OK";
    }
}
