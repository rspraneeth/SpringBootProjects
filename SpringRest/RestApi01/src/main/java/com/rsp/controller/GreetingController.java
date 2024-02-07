package com.rsp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController //@Controller + @ResponseBody is replaced by RestController.
@RequestMapping("/rest")
public class GreetingController {

    @GetMapping("/api1")
//    @ResponseBody
    public ResponseEntity<?> generateGreetings(){
        LocalDateTime dateTime = LocalDateTime.now();
        int hour = dateTime.getHour();
        String body;

        if (hour < 12) body="Good Morning";
        else if (hour < 16) body="Good Afternoon";
        else if (hour < 20) body="Good Evening";
        else body="Good Night";

        return new ResponseEntity<>(body, HttpStatus.OK);
    }
}
