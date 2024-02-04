package com.rsp.service;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class GreetingService implements IGreetingService{
    @Override
    public String generateGreetings() {
        LocalDateTime dateTime = LocalDateTime.now();
        int hr = dateTime.getHour();
        if (hr < 12) return "Good Morning";
        else if (hr < 16) return "Good Afternoon";
        else if (hr < 20) return "Good Evening";
        else return "Good Night";
    }
}
