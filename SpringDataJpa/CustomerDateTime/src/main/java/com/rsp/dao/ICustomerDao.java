package com.rsp.dao;

import com.rsp.bo.Customer;
import org.springframework.data.repository.CrudRepository;

public interface ICustomerDao extends CrudRepository<Customer, Integer> {
}
