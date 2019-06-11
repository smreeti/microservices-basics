package com.smriti.testservice.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "email-service")
@Component
public interface EmailInterface {

    @RequestMapping("/api/test")
    String sayHello();

}



