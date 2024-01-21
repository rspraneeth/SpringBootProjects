package com.rsp;

import com.rsp.bo.VaccineDetails;
import com.rsp.service.VaccineManagementImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class VaccineManagementAppApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(VaccineManagementAppApplication.class, args);
        VaccineManagementImpl service = context.getBean(VaccineManagementImpl.class);

        service.searchByPriceLessThan(501).forEach(v->{System.out.println(v.getName()+" "+v.getCompany());});

        context.close();
    }

}
