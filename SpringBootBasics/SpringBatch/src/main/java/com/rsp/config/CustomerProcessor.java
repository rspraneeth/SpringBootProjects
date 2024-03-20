package com.rsp.config;

import com.rsp.entity.Customer;
import org.springframework.batch.item.ItemProcessor;

public class CustomerProcessor implements ItemProcessor<Customer, Customer> {

    public Customer process(Customer item){

        //logic to process/filter data
        System.out.println("in customerProcessor");
        return item;
    }
}
