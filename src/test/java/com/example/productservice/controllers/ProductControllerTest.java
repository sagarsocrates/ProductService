package com.example.productservice.controllers;

import com.example.productservice.exceptions.InvalidProductIdException;
import com.example.productservice.models.Product;
import com.example.productservice.services.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

//@SpringBootTest
class ProductControllerTest {
//
//    @Autowired
//    private ProductController productController;
//
//    @MockBean
//    private ProductService productService;
//
////    @Test
//    void testGetProductByIdValidCase() throws InvalidProductIdException {
//        //3 A's
//
//        Product product = new Product();
//        product.setId(1L);
//        product.setTitle("iphone 15");
//        product.setDescription("iphone 15");
//        product.setPrice(55000.0);
//
//        when(productService.getProductById(1L)).thenReturn(product);
//
//        ResponseEntity<Product> expectedResponse = productController.getProductById(1L);
//
//        assertEquals(product, expectedResponse.getBody());
//
//        assertEquals(HttpStatus.ACCEPTED, expectedResponse.getStatusCode());
//
//    }
//
//    @Test
//    void testGetProductByIdInvalidCase() throws InvalidProductIdException {
//      when(productService.getProductById(1000L)).
//              thenThrow(new InvalidProductIdException(1000L, "Invalid Product Id"));
//
//      assertThrows(InvalidProductIdException.class,
//              () -> productController.getProductById(1000L)
//      );
//    }

//    @Test
//    void testGetAllProductsValidCase() throws InvalidProductIdException {
//        List<Product> products = new ArrayList<>();
//
//        Product product1 = new Product();
//        product1.setId(1L);
//        product1.setTitle("iphone 15");
//        product1.setDescription("iphone 15");
//
//        Product product2 = new Product();
//        product2.setId(2L);
//        product2.setTitle("iphone 16");
//        product2.setDescription("iphone 16");
//
//        products.add(product1);
//        products.add(product2);
//
//        when(productService.getAllProducts()).thenReturn(products);
//
//        assertEquals(products, productController.getAllProducts());
//    }
}