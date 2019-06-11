package com.smriti.interceptorservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping
@RestController
public class TestController {

    @GetMapping("/hello")
    public String sayHello(){
        return "hello";
    }
}
