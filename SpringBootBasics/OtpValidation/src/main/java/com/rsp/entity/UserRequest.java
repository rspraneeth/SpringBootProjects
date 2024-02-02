package com.rsp.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserRequest {
    private String mail;
    private String otp;
    private LocalDateTime expiry;
}
