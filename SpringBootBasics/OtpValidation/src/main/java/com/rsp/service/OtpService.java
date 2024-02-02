package com.rsp.service;

import com.rsp.entity.OtpResponse;
import com.rsp.entity.UserRequest;
import com.rsp.entity.UserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service
public class OtpService {

    private Map<String, UserRequest> data = new HashMap<>();

    public UserResponse getOtp(String mail) {
        UserResponse res = new UserResponse();

        int rand = (int) (Math.random()*1000000);
        UserRequest user = new UserRequest();
        user.setMail(mail);
        user.setOtp(String.valueOf(rand));
        user.setExpiry(LocalDateTime.now().plusMinutes(1));
        data.put(mail, user);

        res.setMessage("Otp is "+user.getOtp());
        res.setStatus(HttpStatus.CREATED);

        return res;
    }


    public OtpResponse validateOtp(String mail, String otp) {
        OtpResponse res = new OtpResponse();
        if (data.containsKey(mail) && data.get(mail).getOtp().equals(otp) && (LocalDateTime.now().isBefore(data.get(mail).getExpiry()))){
            res.setMessage("Otp is valid.");
            res.setStatus(HttpStatus.ACCEPTED);
        }else {
            res.setMessage("Invalid details");
            res.setStatus(HttpStatus.BAD_REQUEST);
        }
        return res;
    }
}
