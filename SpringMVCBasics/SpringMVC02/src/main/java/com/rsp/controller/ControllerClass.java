package com.rsp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/c1")
public class ControllerClass {

    @RequestMapping("/message")
    public String someMessage(Model model){

        System.out.println(model.getClass().getName()+" is the implementing class for Model.");
        model.addAttribute("name", "Praneeth");
        return "home";
    }

    @GetMapping("/message1")
    public String messageOne(Model model){

        System.out.println(model.getClass().getName()+" is the implementing class for Model.");
        model.addAttribute("name", "Praneeth R");
        return "home";
    }

}
