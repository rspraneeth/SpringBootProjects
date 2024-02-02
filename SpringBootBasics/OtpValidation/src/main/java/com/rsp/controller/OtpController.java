package com.rsp.controller;

import com.rsp.entity.OtpResponse;
import com.rsp.entity.UserOtpRequest;
import com.rsp.entity.UserRequest;
import com.rsp.entity.UserResponse;
import com.rsp.service.OtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/otp")
public class OtpController {



    @Autowired
    private OtpService service;


    @GetMapping("/generateOTP/{mail}")
    public ResponseEntity<UserResponse> generateOTP(@PathVariable String mail){

        UserResponse res = service.getOtp(mail);

        return new ResponseEntity<>(res, res.getStatus());
    }


    @PostMapping("/validateOtp")
    public ResponseEntity<OtpResponse> validateOtp(@RequestBody UserOtpRequest userOtpRequest){

        OtpResponse res = service.validateOtp(userOtpRequest.getMail(), userOtpRequest.getOtp());

        return new ResponseEntity<>(res, res.getStatus());
    }


}
