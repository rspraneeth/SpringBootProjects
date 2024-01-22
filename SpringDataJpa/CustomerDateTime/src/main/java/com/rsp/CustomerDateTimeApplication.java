package com.rsp;

import com.rsp.bo.Customer;
import com.rsp.service.CustomerServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@SpringBootApplication
public class CustomerDateTimeApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(CustomerDateTimeApplication.class, args);
        CustomerServiceImpl service = context.getBean(CustomerServiceImpl.class);
//        Customer c = new Customer("Satya", "HYD", LocalDateTime.of(1997, 6, 15, 6, 27, 35, 56), LocalTime.now(), LocalDate.now());
//        String status = service.registerCustomer(c);
//        System.out.println(status);


        service.getAllCustomers().forEach(System.out::println);



        context.close();
    }

}
