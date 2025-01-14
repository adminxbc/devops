package com.xbc.devops.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/devops")
public class TestController {

    @GetMapping("/test")
    public Object test(){
        System.out.println("hello private jenkins ..........");
        return "hello  test ............ ";
    }
}
