package com.rsp.service;

import com.rsp.dao.ICustomerDao;
import com.rsp.model.CustomerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements ICustomerService{

    @Autowired
    private ICustomerDao customerDao;
    @Override
    public List<CustomerInfo> getCustomers() {
        Iterable<CustomerInfo> list = customerDao.findAll();
        return (List<CustomerInfo>) list;
    }

    @Override
    public void newCustomer(CustomerInfo cust) {
        customerDao.save(cust);
    }

    @Override
    public void deleteCustomer(Integer id) {
        customerDao.deleteById(id);
    }

    @Override
    public Optional<CustomerInfo> findCustomerById(Integer id) {
        return customerDao.findById(id);
    }
}
