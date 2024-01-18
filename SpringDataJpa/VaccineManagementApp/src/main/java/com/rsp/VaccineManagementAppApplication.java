package com.rsp;

import com.rsp.bo.VaccineDetails;
import com.rsp.service.VaccineManagementImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
public class VaccineManagementAppApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(VaccineManagementAppApplication.class, args);
        VaccineManagementImpl service = context.getBean(VaccineManagementImpl.class);

//        String msg = service.registerVaccineDetails(new VaccineDetails("Diana", "ASM", 900));
//        System.out.println(msg);

//        List<VaccineDetails> list = new ArrayList<>();
//        list.add(new VaccineDetails("hawaii1", "GSM", 399));
//        list.add(new VaccineDetails("Covaxin1", "Bharat Biotech", 100));
//        list.add(new VaccineDetails("Covishield1", "Astrazenica", 100));
//        service.registerMultipleVaccineDetails(list).forEach(vac -> System.out.println(vac));

        Long count = service.getVaccineCount();
        System.out.println("Rows count is "+count);


        System.out.println(service.checkAvailability(2L)?"Exists":"Doesnt Exist");

        service.getAllVaccineInfo().forEach(System.out::println);

        service.getVaccinesById(new ArrayList<>(Arrays.asList(1L, 2L, 3L))).forEach(System.out::println);

        System.out.println(service.getVaccineById(8L).orElse(new VaccineDetails()));

        System.out.println(service.removeVaccineById(8L));

        System.out.println(service.removeVaccinesByIds(new ArrayList<>(Arrays.asList(7L, 6L))));

        VaccineDetails v = new VaccineDetails("Covishield", "Astrazenica", 100);
        v.setId(5L);
        System.out.println(service.removeVaccineByObject(v));

        context.close();
    }

}
