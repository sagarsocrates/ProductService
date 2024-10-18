package com.example.productservicedemo.repositories;

import com.example.productservicedemo.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category save(Category category);

    Optional<Category> findByTitle(String title);

    Optional<Category> findById(Long id);
}
