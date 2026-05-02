package com.ws101.escala.repository;

import com.ws101.escala.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    // Task 3.2: Method Naming
    List<Product> findByCategoryNameIgnoreCase(String categoryName);

    // Task 3.2: Custom JPQL
    @Query("SELECT p FROM Product p WHERE p.price BETWEEN :min AND :max")
    List<Product> findByPriceRange(Double min, Double max);
}
