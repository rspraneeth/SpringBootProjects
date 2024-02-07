package com.rsp.dao;

import com.rsp.model.CustomerInfo;
import org.springframework.data.repository.CrudRepository;

public interface ICustomerDao extends CrudRepository<CustomerInfo, Integer> {
}
