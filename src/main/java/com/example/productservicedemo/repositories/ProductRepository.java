package com.example.productservicedemo.repositories;

import com.example.productservicedemo.models.Category;
import com.example.productservicedemo.models.Product;
import com.example.productservicedemo.repositories.projections.ProductwithIdAndTitile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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


    // @Query ("Custom Query") ==> Hql Hibernate Query Language
    @Query("select p.id , p.title from Product p where p.price > 100000 and p.title like '%iphone%' ")
    List<ProductwithIdAndTitile> someRandomQuery();

    @Query("select p.id as id, p.title as title from Product p where p.id = :id ")
    ProductwithIdAndTitile doSomething(@Param("id") Long id);

    //native query using sql
    @Query(value = "select * from product p where p.id = 1 ", nativeQuery = true)
    Product doSomethingSql();

}
