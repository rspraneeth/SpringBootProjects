package com.rsp;

import com.rsp.dao.Employee;
import com.rsp.dao.EmployeeDaoImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Iterator;
import java.util.List;

@SpringBootApplication
public class SpringBootJdbc01Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringBootJdbc01Application.class, args);

        EmployeeDaoImpl emp = context.getBean(EmployeeDaoImpl.class);

        emp.getTheEmployee().forEach(empl -> System.out.println(empl));



        context.close();
    }

}