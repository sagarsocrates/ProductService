package com.example.productservice.services;

import com.example.productservice.dtos.ProductDto;
import com.example.productservice.exceptions.InvalidProductIdException;
import com.example.productservice.models.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {
    Product getProductById(Long id) throws InvalidProductIdException;

    Page<Product> getAllProducts(int pageNumber, int pageSize);

    Product updateProduct(Long id, Product product);

    Product createProduct(Product product);

    Product replaceProduct(Long id, ProductDto productDto);

    void deleteProduct(Long id);
}
