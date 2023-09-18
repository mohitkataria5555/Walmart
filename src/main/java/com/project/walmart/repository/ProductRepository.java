package com.project.walmart.repository;

import com.project.walmart.model.Category;
import com.project.walmart.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    List<Product> findByCategory(Category category);



}
