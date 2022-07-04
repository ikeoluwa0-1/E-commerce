package com.example.admin.repository;

import com.example.admin.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UpdateProductRepository extends JpaRepository<Product, Long> {
    Product findProductById(Long id);
}
