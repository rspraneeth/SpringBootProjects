package com.rsp.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component(value = "voter")
@PropertySource(value = "com/rsp/commons/application.properties")
public class Voter {

    @Value("${voter.info.name}")
    private String name;

    @Value("${voter.info.age}")
    private int age;

    static {
        System.out.println("Voter class loading...");
    }

//    spring bean lifecycle : static block
//                              -> non-static block (instantiation)
//                                  -> constructor, init() (@PostConstruct)
//                                      -> method calls
//                                          -> destroy()(@PreDestroy)

    public Voter(){
        System.out.println("Voter is instantiated.");
    }

    @PostConstruct
    public void myInit(){
        System.out.println("initialized... myInit().");
    }
    public void checkEligibility(){
        System.out.println("Method call with business logic.");
        if (age>=18) System.out.println("Hello, "+name+", You're eligible for voting.");
        else System.out.println("Hello, "+name+", You're not eligible for voting.");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Bean is destroyed...");
    }
}
