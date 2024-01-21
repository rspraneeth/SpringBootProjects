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

        service.searchByCompany("ASM").forEach(System.out::println);

        service.filterByPriceRange(300, 900).forEach(v -> System.out.println(v.getCompany()+" "+v.getPrice()+" "+v.getId()));

        service.filterByPriceSorted().forEach(System.out::println);

        service.filterByPriceRangeSorted(350, 750).forEach(System.out::println);

        service.searchByPriceBelow(501).forEach(System.out::println);

        service.searchByNameInAndPriceBetween(Arrays.asList("efgh", "mnop", "uvwx", "Diana"), 350, 750).forEach(System.out::println);


        context.close();
    }

}
