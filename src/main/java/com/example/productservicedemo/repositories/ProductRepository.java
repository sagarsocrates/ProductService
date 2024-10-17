package com.example.productservicedemo.repositories;

import com.example.productservicedemo.models.Category;
import com.example.productservicedemo.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findById(long id);

    Optional<Product> findByTitleAndDescription(String title, String description);

    List<Product> findByTitleContaining(String word);

    List<Product> findTopThreeByTitle(String title); //limit result by 3

    Optional<Product> findByCategory(Category category);

    void deleteById(long id);

    void deleteByTitle(String title);

    Product save(Product product);

}
