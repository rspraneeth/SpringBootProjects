package com.rsp.main;

import com.rsp.util.Password;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LaunchApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        Password p = context.getBean(Password.class);
//        p.disp();

    }
}
