package com.rsp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
@ComponentScan(basePackages = {"com.rsp"})
public class JavaConfiguration {

    public JavaConfiguration(){
        System.out.println("Java Config instantiated.");
    }

    @Bean
    public LocalDateTime createBean(){
        System.out.println("LocalDateTime obj by dev.");
        return LocalDateTime.now();
    }

}
