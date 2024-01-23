package com.rsp.service;


import com.rsp.bo.Customer;
import com.rsp.dto.CustomerDTO;

import java.util.List;

public interface ICustomerService {
    public String registerCustomer(CustomerDTO dto);
    public List<Customer> findAll();

    public String removeDoc(String id);
}
