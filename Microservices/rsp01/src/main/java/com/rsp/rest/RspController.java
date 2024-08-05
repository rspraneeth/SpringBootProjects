package com.rsp.rest;


import com.rsp.service.RspService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RspController {

    @Autowired
    private RspService service;

    @Autowired
    private RspFeignClient feignClient;;

    @GetMapping("/info")
    public String getCourseInfo(){
        return service.courseInfo();
    }

    @GetMapping("/msg-from-rsp02")
    public String getMsgFromRsp02(){
        return "In App1, getting message from App2: "+feignClient.invokeMessageFromRsp02();
    }
}
