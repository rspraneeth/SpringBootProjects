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

//        service.fetchDetailsByCompany("ASM").forEach(System.out::println);
//
//        service.fetchVaccineByCompanies("ASM", "abcd").forEach(System.out::println);
//
//        service.fetchByPriceRange(250, 750).forEach(System.out::println);
//
//        service.fetchByName("Diana").forEach(o -> System.out.println(Arrays.toString(o)));

//        System.out.println(service.updatePriceBasedOnVaccine(455, "Diana"));

//        System.out.println(service.deleteVaccineByN("Llama"));
//
//        System.out.println(service.deleteVaccineByPriceRange(300, 401));

//        System.out.println(service.insertVaccine(345, "RSP", "ASM"));

        System.out.println(service.getTheSystemDateAndTime());



        context.close();
    }

}
