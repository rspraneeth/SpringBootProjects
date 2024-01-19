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
        VaccineDetails vaccine = new VaccineDetails("Covaxin", "Bharat Biotech", 100);

        service.searchVaccineByData(vaccine, true, "name", "company").forEach(System.out::println);

        service.searchVaccineByGivenData(vaccine).forEach(System.out::println);

        System.out.println(service.searchById(2L));

        List<Long> ids = new ArrayList<>(Arrays.asList(3L, 4L));
        System.out.println(service.removeVaccineByIds(ids));

        context.close();
    }

}
