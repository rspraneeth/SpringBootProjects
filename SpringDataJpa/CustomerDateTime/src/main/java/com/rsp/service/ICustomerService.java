package com.rsp.service;

import com.rsp.bo.Customer;

import java.util.List;

public interface ICustomerService {

    public String registerCustomer(Customer customer);
    public List<Customer> getAllCustomers();
}
