package com.rsp.main;

import com.rsp.beans.Voter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LaunchApp {
    public static void main(String[] args) {
        System.out.println("Spring container started...");
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Voter voter = (Voter) context.getBean("voter");
        voter.checkEligibility();

        
        System.out.println("Spring container stopped");
    }
}
