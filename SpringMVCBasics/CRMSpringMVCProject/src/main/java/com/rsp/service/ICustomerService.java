package com.rsp.service;

import com.rsp.model.CustomerInfo;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
    public List<CustomerInfo> getCustomers();
    public void newCustomer(CustomerInfo cust);
    
    public void deleteCustomer(Integer id);

    Optional<CustomerInfo> findCustomerById(Integer id);
}
