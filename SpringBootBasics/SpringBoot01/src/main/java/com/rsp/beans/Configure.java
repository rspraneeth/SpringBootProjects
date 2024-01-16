package com.rsp.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalTime;

@Configuration
public class Configure {

    @Bean
    public LocalTime createTimeBean(){
        System.out.println("In configure class, createTimeBean method, returning LocalTime value.");
        return LocalTime.now();
    }
}
