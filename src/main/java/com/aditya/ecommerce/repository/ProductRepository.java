package com.aditya.ecommerce.repository;

import com.aditya.ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByIsFeaturedTrue();

    List<Product> findByCategory(String category);

    @Query(value = "SELECT * FROM product ORDER BY RAND LIMIT 3", nativeQuery = true)
    List<Product> findRandomProducts();
}
