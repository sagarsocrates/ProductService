package com.example.productservicedemo.controllers;

import com.example.productservicedemo.dtos.ProductDto;
import com.example.productservicedemo.exceptions.InvalidProductIdException;
import com.example.productservicedemo.exceptions.ProductControllerSpecificException;
import com.example.productservicedemo.models.Product;
import com.example.productservicedemo.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    ProductController(@Qualifier("selfProductService") ProductService productService) {
        this.productService = productService;
    }
    //localhost:2020/prodcuts/10
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") long id) throws InvalidProductIdException {

        Product product =  productService.getProductById(id);
        return new ResponseEntity<>(product, HttpStatus.ACCEPTED);
    }

    //localhost:2020/prodcuts
    @GetMapping("/")
    public List<Product> getAllProducts() {
          return  productService.getAllProducts();
    }

    //create
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    //Partial Update
    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    //Replace Product
    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long id, @RequestBody ProductDto product) {

        return productService.replaceProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
    }

    @ExceptionHandler(ProductControllerSpecificException.class)
    public ResponseEntity<Void> handleProductControllerSpecificException(){
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
