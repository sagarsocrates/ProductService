package com.example.productservicedemo.services;

import com.example.productservicedemo.models.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(Long id);

    List<Product> getAllProducts();

    Product updateProduct(Long id, Product product);

    Product createProduct(Product product);

    Product replaceProduct(Long id, Product product);

    void deleteProduct(Long id);
}
