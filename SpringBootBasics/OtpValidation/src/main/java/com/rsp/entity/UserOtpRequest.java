package com.rsp.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserOtpRequest {
    private String mail;
    private String otp;
}
