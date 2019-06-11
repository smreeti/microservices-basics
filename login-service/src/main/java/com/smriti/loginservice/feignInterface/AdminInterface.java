package com.smriti.loginservice.feignInterface;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "AdminService")
@Component
public interface AdminInterface {

    @GetMapping("/adminById/{id})
            
}
