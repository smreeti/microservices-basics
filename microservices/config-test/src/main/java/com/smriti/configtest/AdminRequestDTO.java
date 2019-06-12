package com.smriti.configtest;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminRequestDTO {

    private String username;

    private String emailAddress;

    private Character emailSent;

    private String password;
}
