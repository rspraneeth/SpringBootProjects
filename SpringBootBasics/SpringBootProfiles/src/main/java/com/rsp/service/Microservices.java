package com.rsp.service;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Microservices implements Courses {

    @Override
    public boolean registerToCourse(Double cost)
    {
        System.out.println("Microservices course registered amount paid "+cost);
        return true;
    }

}
