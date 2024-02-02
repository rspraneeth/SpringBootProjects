package com.rsp.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;


@Getter
@Setter
public class OtpResponse {

    private String message;
    private HttpStatus status;

}
