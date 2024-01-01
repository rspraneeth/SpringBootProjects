package com.rsp.main;

import com.rsp.beans.Amazon;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LaunchApp {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//       if we use application context(eager loading), on activating container, spring will consider objects as bean.


        Amazon amz = context.getBean("amazon", Amazon.class);
        System.out.println(amz.initiateDelivery(55.9));
    }
}
