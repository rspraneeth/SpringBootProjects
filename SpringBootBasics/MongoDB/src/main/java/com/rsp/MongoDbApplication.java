package com.rsp;

import com.rsp.dto.CustomerDTO;
import com.rsp.generator.IdGenerator;
import com.rsp.service.CustomerServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MongoDbApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(MongoDbApplication.class, args);
        CustomerServiceImpl service = context.getBean(CustomerServiceImpl.class);

//        System.out.println(service.registerCustomer(new CustomerDTO(101, "Kohli", "Bangalore")));

//        System.out.println(service.removeDoc("65af531c4337c85c86a3095c"));

        service.findAll().forEach(System.out::println);

//        CustomerDTO dto = new CustomerDTO();
//        dto.setId(IdGenerator.generateId());
//        dto.setCusNo(102);
//        dto.setName("Teddy");
//
//        System.out.println(service.registerCustomer(dto));

        context.close();
    }

}
