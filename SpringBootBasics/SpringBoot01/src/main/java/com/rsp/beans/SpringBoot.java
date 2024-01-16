package com.rsp.beans;

import org.springframework.stereotype.Component;

@Component("springboot")
public class SpringBoot implements Course{

    public SpringBoot(){
        System.out.println("SpringBoot bean created.");
    }
    @Override
    public boolean selectCourse(double amount) {
        System.out.println("SpringBoot course is selected and fee paid is "+amount);
        return true;
    }
}
