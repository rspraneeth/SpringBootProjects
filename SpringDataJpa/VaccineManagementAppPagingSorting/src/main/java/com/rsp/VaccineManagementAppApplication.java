package com.rsp;

import com.rsp.bo.VaccineDetails;
import com.rsp.service.VaccineManagementImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class VaccineManagementAppApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(VaccineManagementAppApplication.class, args);
        VaccineManagementImpl service = context.getBean(VaccineManagementImpl.class);

//        Iterable<VaccineDetails> list = service.fetchDetails(false, "name", "company");
//        list.forEach(System.out::println);
//
//        service.fetchDetailsPage(1, 3, true, "name", "company").forEach(System.out::println);

        service.fetchDetailsByPagination(5);

        context.close();
    }

}
