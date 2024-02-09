package com.rsp.controller;

import com.rsp.pojo.Details;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.concurrent.ConcurrentHashMap;

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

    @GetMapping("/msg")
    public String generateMessage(@RequestParam(value = "name", required = false, defaultValue = "Buddy") String name){

        return "Hello "+name+", Have a good day!";
    }

    @GetMapping("/msg/{name}")
    public String generateMsg(@PathVariable("name") String name){

        return "Hello "+name+", Have a good day!";
    }

    @PostMapping(value = "/msg2")
    public Details generateMsgDetails(@RequestBody Details details){

        return details;
    }

    @PostMapping(value = "/msg3", params = "name=Praneeth")
    public String generateMsgDetailsParam(@RequestParam String name, @RequestParam String mail, @RequestParam Double salary){
        return "Details: "+name+", "+mail+", "+salary;
    }




}
