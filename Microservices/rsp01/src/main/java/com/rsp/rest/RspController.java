package com.rsp.rest;

import com.rsp.service.RspService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RspController {

    @Autowired
    private RspService service;

    @GetMapping("/info")
    public String getCourseInfo(){
        return service.courseInfo();
    }
}
