package com.rsp.beans;

import org.springframework.stereotype.Component;

@Component("java")
public class Java implements Course{

    public Java(){
        System.out.println("Java bean created.");
    }

    @Override
    public boolean selectCourse(double amount) {
        System.out.println("Java course is selected and fee paid is "+amount);
        return true;
    }
}
