package com.rsp.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String greet(HttpSession session){
        return "Hello "+session.getId();
    }

    @GetMapping("/about")
    public String about(){
        return "rsp";
    }
}
