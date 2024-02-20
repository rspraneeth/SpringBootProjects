package controller;

import Service.ProductService;
import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("getProducts/{offset}/{pageSize}")
    public ResponseEntity<List<Product>> getProducts(@PathVariable int offset, @PathVariable int pageSize){

        List<Product> list = service.getAllProducts(offset, pageSize);

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

}
