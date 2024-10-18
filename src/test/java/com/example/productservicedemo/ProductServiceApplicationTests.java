package com.example.productservicedemo;

import com.example.productservicedemo.models.Category;
import com.example.productservicedemo.models.Product;
import com.example.productservicedemo.repositories.CategoryRepository;
import com.example.productservicedemo.repositories.ProductRepository;
import com.example.productservicedemo.repositories.projections.ProductwithIdAndTitile;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ProductServiceApplicationTests {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    void contextLoads() {
    }

    @Test
    public void testQueries(){
        List<ProductwithIdAndTitile> products = productRepository.someRandomQuery();

        ProductwithIdAndTitile product = productRepository.doSomething(1L);
        System.out.println(product.getId());
        System.out.println(product.getTitle());

        Product product1 = productRepository.doSomethingSql();

        categoryRepository.deleteById(102L);
        System.out.println("DEBUG");
    }


}
