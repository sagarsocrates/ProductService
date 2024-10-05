package com.example.productservicedemo.controllers;

import com.example.productservicedemo.models.Product;
import com.example.productservicedemo.services.ProductService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    ProductController(ProductService productService) {
        this.productService = productService;
    }
    //localhost:2020/prodcuts/10
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") long id) {
            return productService.getProductById(id);
//            return new Product();
    }

    //localhost:2020/prodcuts
    @GetMapping("/")
    public List<Product> getAllProducts() {

        return productService.getAllProducts();
//        return new ArrayList<Product>();
    }

    //create
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return new Product();
    }

    //Partial Update
    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        return new Product();
    }

    //Replace Product
    @PutMapping
    public Product replaceProduct(@PathVariable("id") Long id, @RequestBody Product product) {

        return productService.replaceProduct(id, product);
//        return new Product();
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id) {

    }

}
