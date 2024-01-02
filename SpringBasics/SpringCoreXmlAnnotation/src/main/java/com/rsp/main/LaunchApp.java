package com.rsp.main;

import com.rsp.beans.Amazon;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LaunchApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Amazon amazon = context.getBean("amazon", Amazon.class);
        amazon.initiateDelivery(34.45);
    }
}
