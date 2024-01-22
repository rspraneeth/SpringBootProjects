package com.rsp.service;

import com.rsp.bo.Customer;
import com.rsp.dao.ICustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService{

    @Autowired
    private ICustomerDao repo;
    @Override
    public String registerCustomer(Customer customer) {
        Integer id = repo.save(customer).getId();
        return "Saved details with id "+id;
    }

    @Override
    public List<Customer> getAllCustomers() {
        List<Customer> customers = (List<Customer>) repo.findAll();
        return customers;
    }
}
