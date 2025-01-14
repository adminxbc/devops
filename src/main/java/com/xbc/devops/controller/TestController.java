package com.xbc.devops.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/devops")
public class TestController {
//    @Autowired


    @GetMapping("/test")
    public Object test(){
        System.out.println("test");
        return "hello  test port 8866...........tag v1.6 ";
    }
}
