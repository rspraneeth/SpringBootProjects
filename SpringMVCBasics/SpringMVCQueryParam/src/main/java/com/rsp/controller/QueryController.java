package com.rsp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class QueryController {

    //localhost:8080/getmessage?name=praneeth  //query parameter(data travelling at end of url, after ?, form of key value pair)
    //localhost:8080/getmessage?name=Praneeth&course=Java
    //we use @RequestParam(Query parameter) annotation to receive query param(if key and parameter name is matching, need not use annotation)
    @GetMapping("/getmessage")
    public String displayMessage(@RequestParam("name") String name, @RequestParam("course") String course,Map<String, Object> model){
        String msg = "Hello, How you doin'? "+name+", you course: "+course;
        model.put("message", msg);
        return "index";
    }

    //localhost:8080/getmessage/Ted/Spring
    //Path Parameter contains data directly without key, present anywhere in url
    @GetMapping("/getmessage/{name}/{course}")
    public String display(@PathVariable String name, @PathVariable String course, Map<String, Object> model){
        String msg = "Hello, How you doin'? "+name+", you course: "+course;
        model.put("message", msg);
        return "index";
    }
}
