package com.rsp.controller;

import com.rsp.model.Customer;
import com.rsp.model.Product;
import com.rsp.service.CustomerService;
import com.rsp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MultiDbApiController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CustomerService customerService;

    @GetMapping("/get-products")
    public ResponseEntity<List<Product>> getAllProducts(){

        return new ResponseEntity<>(productService.fetchAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/get-customers")
    public ResponseEntity<List<Customer>> getAllCustomers(){

        return new ResponseEntity<>(customerService.fetchAllCustomers(), HttpStatus.OK);
    }

    @PostMapping("/save-products")
    public ResponseEntity<String> saveAllProducts(){

        return new ResponseEntity<>(productService.saveMultipleProducts(), HttpStatus.OK);
    }

    @PostMapping("/save-customers")
    public ResponseEntity<String> saveAllCustomers(){

        return new ResponseEntity<>(customerService.saveMultipleCustomers(), HttpStatus.OK);
    }

}
