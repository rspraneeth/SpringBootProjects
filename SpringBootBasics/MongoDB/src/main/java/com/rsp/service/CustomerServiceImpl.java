package com.rsp.service;

import com.rsp.bo.Customer;
import com.rsp.dao.ICustomerRepo;
import com.rsp.dto.CustomerDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements ICustomerService{

    @Autowired
    private ICustomerRepo repo;
    @Override
    public String registerCustomer(CustomerDTO dto) {
        System.out.println(repo.getClass().getName()+" is implementing Mongo repo");
        Customer custDoc = new Customer();
        BeanUtils.copyProperties(dto, custDoc); //to copy data from one obj to another

        Customer c = repo.save(custDoc);
        return "Saved as document in MongoDB with id "+c.getCusNo()+" "+c.getId();
    }

    @Override
    public List<Customer> findAll() {
        return repo.findAll();
    }

    @Override
    public String removeDoc(String id) {
        Optional<Customer> doc = repo.findById(id);

        if (doc.isPresent()){
            repo.deleteById(doc.get().getId());
            return "Deleted document with id "+id;
        }
        return "Doc not found to delete";
    }
}
