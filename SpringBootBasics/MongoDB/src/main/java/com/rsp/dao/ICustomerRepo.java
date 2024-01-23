package com.rsp.dao;

import com.rsp.bo.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ICustomerRepo extends MongoRepository<Customer, String> {

}
