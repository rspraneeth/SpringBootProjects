package com.rsp.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Rsp2Controller {

    @Autowired
    private RspFeignClient feignClient;

    @Autowired
    private Environment environment;

    @GetMapping("/more-info")
    public String getMoreCourseInfo(){

//        RestTemplate template = new RestTemplate();
//        ResponseEntity<String> res = template.getForEntity("http://localhost:8484/info", String.class);
//        String response = res.getBody();

        String response = feignClient.invokeGetCourseInfo();

        System.out.println("in app 2, with port number: "+environment.getProperty("local.server.port"));

        return "Response from rsp01 service2 is: "+response+" and current end points response from service2 is: This course started already.....";
    }
}
