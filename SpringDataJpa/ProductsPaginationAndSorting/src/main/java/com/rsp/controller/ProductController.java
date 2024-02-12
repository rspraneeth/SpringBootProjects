package com.rsp.controller;

import com.rsp.dto.ApiResponse;
import com.rsp.entity.Product;
import com.rsp.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/products")
public class ProductController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService service;

    @GetMapping
    private ApiResponse<List<Product>> getProducts(){
        logger.info("getting all products");
        List<Product> list = service.findAllProducts();
        logger.info("fetched all products");
        logger.debug("debug logger");
        return new ApiResponse<>(list.size(), list);
    }


    //sorting
    @GetMapping("/{field}")
    private ApiResponse<List<Product>> getProductsWithSort(@PathVariable String field){
        List<Product> products = service.findProductsWithSorting(field);
        return new ApiResponse<>(products.size(), products);
    }

    //pagination, with page number, page size(products in each page)
    @GetMapping("/pages/{offset}/{pageSize}")
    private ApiResponse<Page<Product>> getProductsWithPagination(@PathVariable int offset, @PathVariable int pageSize){
        Page<Product> pages = service.findProductsWithPagination(offset, pageSize);
        return new ApiResponse<>(pages.getSize(), pages);
    }

    //both pagination and sorting based on a field
    @GetMapping("/pages/{offset}/{pageSize}/{field}")
    private ApiResponse<Page<Product>> getProductsWithPaginationAndSorting(@PathVariable int offset, @PathVariable int pageSize, @PathVariable String field){
        Page<Product> pages = service.findProductsWithPaginationAndSorting(offset, pageSize, field);
        return new ApiResponse<>(pages.getSize(), pages);
    }

    //pagination for products less than maxPrice
    @GetMapping("/pagesMaxPrice/{offset}/{pageSize}/{maxPrice}")
    private ApiResponse<Page<Product>> getProductsWithPaginationMaxPrice(@PathVariable int offset, @PathVariable int pageSize, @PathVariable Long maxPrice){
        Page<Product> pages = service.findProductsByMaxPricePages(offset, pageSize, maxPrice);
        return new ApiResponse<>(pages.getSize(), pages);
    }

    //pagination for products less than maxPrice, sorted order
    @GetMapping("/pages-sort/{offset}/{pageSize}/{maxPrice}")
    private ApiResponse<Page<Product>> getProductsWithPaginationAndSortingMaxPrice(@PathVariable int offset, @PathVariable int pageSize, @PathVariable Long maxPrice){
        Page<Product> pages = service.findProductsByMaxPricePagesSort(offset, pageSize, maxPrice);
        return new ApiResponse<>(pages.getSize(), pages);
    }




}
