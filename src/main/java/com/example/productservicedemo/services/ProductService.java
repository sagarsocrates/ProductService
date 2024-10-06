package com.example.productservicedemo.services;

import com.example.productservicedemo.dtos.ProductDto;
import com.example.productservicedemo.exceptions.InvalidProductIdException;
import com.example.productservicedemo.models.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(Long id) throws InvalidProductIdException;

    List<Product> getAllProducts();

    Product updateProduct(Long id, Product product);

    Product createProduct(Product product);

    Product replaceProduct(Long id, ProductDto productDto);

    void deleteProduct(Long id);
}
