package com.davacom.thymeleafappjdbc.repository;

import com.davacom.thymeleafappjdbc.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
    Product findProductById(Long id);
}
