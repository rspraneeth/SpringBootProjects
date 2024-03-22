package com.rsp.service;

import com.rsp.model.Customer;
import com.rsp.model.Product;
import com.rsp.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    public List<Customer> fetchAllCustomers() {
        return customerRepo.findAll();
    }

    public String saveMultipleCustomers(){
        for (int i=1; i <= 50; i++){
            customerRepo.save(new Customer(i, "Cust"+i, new Random().ints(1001, 9999).toString()+"@mail.com"));
        }

        return "Saved multiple Customers into db";
    }
}
