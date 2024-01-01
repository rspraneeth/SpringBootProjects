package com.rsp.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Configure {
    public Configure(){
        System.out.println("Configure obj created.");
    }

    @Bean
    public boolean generatePasswordAlgo(){
        Password p = new Password("SHA3");
        return true;
    }
}
