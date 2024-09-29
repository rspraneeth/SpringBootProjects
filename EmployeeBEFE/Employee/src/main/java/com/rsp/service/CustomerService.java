package com.rsp.service;

import com.rsp.entity.Customer;
import com.rsp.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public Customer postCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long id) {
        Optional<Customer> cust = customerRepository.findById(id);
        return cust.orElse(null);

    }

    public Customer updateCustomer(Long id, Customer customer) {
        Optional<Customer> cust = customerRepository.findById(id);
        if (cust.isPresent()) {
            Customer existingCustomer = cust.get();
            existingCustomer.setName(customer.getName());
            existingCustomer.setEmail(customer.getEmail());
            existingCustomer.setPhone(customer.getPhone());
            return customerRepository.save(existingCustomer);
        }
        else {
            return null;
        }
    }

    public String deleteCustomer(Long id) {
        Optional<Customer> cust = customerRepository.findById(id);
        if (cust.isPresent()) {
            customerRepository.delete(cust.get());
            return "Customer deleted with id: "+id;
        }else return "Customer not found";
    }
}
