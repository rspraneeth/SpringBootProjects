package com.rsp.rest;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "RSP02")
public interface RspFeignClient {

    @GetMapping("/msg")
    public String invokeMessageFromRsp02();
}
