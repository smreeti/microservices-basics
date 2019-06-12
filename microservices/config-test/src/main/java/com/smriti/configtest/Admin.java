package com.smriti.configtest;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "admin")
@Entity
@Getter
@Setter
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "email_address", length = 200)
    private String emailAddress;

    @Column(name="password")
    private String password;

    @Column(name = "email_sent")
    private Character emailSent;
}
