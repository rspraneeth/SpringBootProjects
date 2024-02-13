package com.rsp.advice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter @Setter @AllArgsConstructor @ToString
public class ErrorDetails {

    private String statusCode;
    private String msg;
    private LocalDateTime when;
}
