package com.rsp.controller;

import com.rsp.dto.ApiResponse;
import com.rsp.entity.Product;
import com.rsp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping
    private ApiResponse<List<Product>> getProducts(){

        List<Product> list = service.findAllProducts();

        return new ApiResponse<>(list.size(), list);
    }


}
