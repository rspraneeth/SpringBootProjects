package com.rsp.beans;

import org.springframework.stereotype.Component;

@Component("hibernate")
public class Hibernate implements Course{

    public Hibernate(){
        System.out.println("Hibernate bean created.");
    }

    @Override
    public boolean selectCourse(double amount) {
        System.out.println("Hibernate course is selected and fee paid is "+amount);
        return true;
    }
}
