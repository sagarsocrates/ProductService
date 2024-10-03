package com.example.productservicedemo.controllers;

import com.example.productservicedemo.models.Product;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    //localhost:2020/prodcuts/10
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") long id) {
            return new Product();
    }

    //localhost:2020/prodcuts
    @GetMapping("/")
    public List<Product> getAllProducts() {
        return new ArrayList<Product>();
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
        return new Product();
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id) {

    }

}
