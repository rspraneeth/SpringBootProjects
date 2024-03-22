package com.rsp.service;

import com.rsp.model.Product;
import com.rsp.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.random.RandomGenerator;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public List<Product> fetchAllProducts() {

        return productRepo.findAll();
    }

    public String saveMultipleProducts(){
        for (int i=1; i <= 50; i++){
            productRepo.save(new Product(i, "Prod"+i,  new Random().nextInt(1001, 9999)));
        }
        return "Saved Multiple Products into db";
    }
}
