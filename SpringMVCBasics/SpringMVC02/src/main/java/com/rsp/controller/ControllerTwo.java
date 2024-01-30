package com.rsp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/c2")
public class ControllerTwo {

    @GetMapping("/skill")
    public String someMessage2(Model model){
        model.addAttribute("name", "Praneeth, you can do it!!!");

        return "index";
    }

    @GetMapping("/alien")
    public String someMessage3(Map<String, Object> model){
        model.put("name", "Praneeth R, you can do it!!!");

        return "index";
    }

    @GetMapping("/rsp")
    public void someMessage4(Map<String, Object> model){
        model.put("name", "RSP, you can do it!!!");

    }
}
