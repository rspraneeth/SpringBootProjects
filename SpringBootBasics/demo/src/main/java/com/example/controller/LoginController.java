package com.example.controller;

import com.example.model.LoginRequest;
import com.example.model.LoginResponse;
import com.example.service.LoginService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@AllArgsConstructor
public class LoginController {

    LoginService service;

    @PostMapping("login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest){
        LoginResponse loginResponse = service.validate(loginRequest);

        return new ResponseEntity<>(loginResponse, loginResponse.getStatus());
    }

}
