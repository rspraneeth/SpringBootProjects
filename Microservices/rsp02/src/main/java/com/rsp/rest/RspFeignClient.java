package com.rsp.rest;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "RSP01")
public interface RspFeignClient {

    @GetMapping("/info")
    public String invokeGetCourseInfo();

}
