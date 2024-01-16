package com.rsp.beans;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class GreetMe {

    @Autowired
    private LocalDateTime date;

    public GreetMe(){
        System.out.println("GreetMe bean create...");
    }

    public String generateGreeting(String name){
        int hr = date.getHour();

        if(hr < 12) return "Good Morning "+name;
        else if (hr < 16) return "Good Afternoon "+name;
        else if (hr < 20) return "Good Evening "+name;
        else return "Good Night "+name;

    }

}
