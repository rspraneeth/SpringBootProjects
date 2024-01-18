package com.example.service;

import com.example.model.LoginRequest;
import com.example.model.LoginResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    public LoginResponse validate(LoginRequest loginRequest) {
        System.out.println("Validating...");
        LoginResponse loginResponse = new LoginResponse();
        if (loginRequest.getUserName().isEmpty() || loginRequest.getPassword().isEmpty()){
            loginResponse.setMessage("Invalid Data");
            loginResponse.setStatus(HttpStatus.BAD_REQUEST);
            return loginResponse;
        }
        loginResponse.setMessage("Valid Data");
        loginResponse.setStatus(HttpStatus.ACCEPTED);
        return loginResponse;
    }
}
