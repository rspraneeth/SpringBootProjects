package com.rsp;

import com.rsp.bo.VaccineDetails;
import com.rsp.service.VaccineManagementImpl;
import com.rsp.view.ResultView1;
import com.rsp.view.ResultView2;
import com.rsp.view.ResultView3;
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

        service.fetchByCompany("ASM", ResultView2.class).forEach(v-> System.out.println(v.getId()+" "+v.getName()+" "+v.getCompany()));

        service.fetchByCompany("ASM", ResultView3.class).forEach(v -> System.out.println(v.getPrice()));

        service.fetchByCompany("ASM", ResultView1.class).forEach(v -> System.out.println(v.getId()+" "+v.getCompany()));

        context.close();
    }

}
