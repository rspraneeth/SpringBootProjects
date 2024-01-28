package com.rsp.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FirstWebController {

    @RequestMapping("/welcome")
    public ModelAndView displayMessage(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("message", "Welcome to my works");
        mv.setViewName("index");

        return mv;
    }
}
