package com.rsp.main;

import com.rsp.beans.GreetMe;
import com.rsp.config.JavaConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LaunchApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfiguration.class);
        GreetMe gr = context.getBean(GreetMe.class);
        System.out.println(gr.generateGreeting("RSP"));
    }
}
