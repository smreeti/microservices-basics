package com.smriti.configtest.controller;

import com.smriti.configtest.Admin;
import com.smriti.configtest.AdminRepository;
import com.smriti.configtest.AdminRequestDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ConfigTestController {

    @Value("${message}")
    private String message;

    @Autowired
    private AdminRepository adminRepository;

    @PostMapping("/add")
    public ResponseEntity<Void> addAdmin(@RequestBody AdminRequestDTO requestDTO) {
        ModelMapper modelMapper = new ModelMapper();

        Admin admin = modelMapper.map(requestDTO, Admin.class);
        admin.setPassword(BCrypt.hashpw(requestDTO.getPassword(), BCrypt.gensalt()));
        adminRepository.save(admin);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/hello")
    public String sayhello() {
        return message;
    }
}
