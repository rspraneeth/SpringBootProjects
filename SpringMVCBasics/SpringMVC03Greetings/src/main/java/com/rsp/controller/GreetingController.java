package com.rsp.controller;

import com.rsp.service.IGreetingService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/greet")
public class GreetingController {

    @Autowired
    private IGreetingService service;

//    @GetMapping("/getWish")
//    public void showResponse(Map<String, Object> model){
//        model.put("greet", service.generateGreetings());
//    }

//    @GetMapping("/getWish")
//    public Map<String, Object> showResponse(){
//        String greet = service.generateGreetings();
//        Map<String, Object> map = new HashMap<>();
//        map.put("greet", greet);
//        return map;
//    }


    @GetMapping("/getWish")
    public void showResponse(HttpServletResponse response) throws IOException {
        String greet = service.generateGreetings();
        PrintWriter writer = response.getWriter();
        writer.println("<h1>Directly from controller"+greet+"</h1>");
    }
}
