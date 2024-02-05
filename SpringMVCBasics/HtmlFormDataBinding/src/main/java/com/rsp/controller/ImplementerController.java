package com.rsp.controller;

import com.rsp.model.Implementers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.Map;

//HtmlFormDataBinding - ui to controller, binding data to our pojo class, using property editors internally, spring will bind
@Controller
public class ImplementerController {

    @GetMapping("/register")
    public String responseHome(){
        return "register";
    }

    @PostMapping("/register")
    public String registerData(Map<String, Object> model, @ModelAttribute("request") Implementers request){

        model.put("req", request);
        return "result";
    }



}
