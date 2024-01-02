package com.rsp.main;

import com.rsp.bean.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LaunchApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Employee e = context.getBean("student", Employee.class);
        System.out.println("\n");
        System.out.println(e);
        System.out.println(e.empActivity());
        System.out.println("\n");

        Employee e1 = context.getBean("emp", Employee.class);
        System.out.println(e1);
        System.out.println(e1.empActivity());
        System.out.println("\n");

        Employee e2 = context.getBean("emp1", Employee.class);
        System.out.println(e2);
        System.out.println(e2.empActivity());
        System.out.println("\n");

        Employee e3 = context.getBean("emp2", Employee.class);
        System.out.println(e3);
        System.out.println(e3.empActivity());
        System.out.println("\n");
    }
}
