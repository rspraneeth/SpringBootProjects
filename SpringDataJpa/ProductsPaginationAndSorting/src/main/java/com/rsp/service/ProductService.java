package com.rsp.service;

import com.rsp.entity.Product;
import com.rsp.repository.ProductRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repo;


//    initiating products table with random 200 products, so we only run this for once initially to load values into db
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

    public List<Product> findProductsWithSorting(String field){
        return repo.findAll(Sort.by(Sort.Direction.ASC, field)); //sort by field, asc order
    }

    public Page<Product> findProductsWithPagination(int offset, int pageSize){

        return repo.findAll(PageRequest.of(offset, pageSize));

    }

    public Page<Product> findProductsWithPaginationAndSorting(int offset, int pageSize, String field){

        return repo.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(Sort.Direction.ASC, field)));

    }

}
