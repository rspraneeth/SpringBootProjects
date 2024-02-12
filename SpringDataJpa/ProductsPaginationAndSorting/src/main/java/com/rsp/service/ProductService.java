package com.rsp.service;

import com.rsp.entity.Product;
import com.rsp.repository.ProductRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repo;


//    initiating products table with random 200 products
//    @PostConstruct
//    public void initDB(){
//        List<Product> products = IntStream.rangeClosed(1, 200)
//                .mapToObj(i->new Product("product "+i, new Random().nextInt(100), (long) new Random().nextInt(50000)))
//                .toList();
//        repo.saveAll(products);
//    }

    public List<Product> findAllProducts(){
        return repo.findAll();
    }
}
