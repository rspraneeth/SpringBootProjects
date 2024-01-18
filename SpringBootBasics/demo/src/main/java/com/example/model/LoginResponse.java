package com.example.model;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class LoginResponse {
    private String message;
    private HttpStatus status;
}
