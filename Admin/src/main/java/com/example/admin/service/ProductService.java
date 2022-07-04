package com.example.admin.service;

import com.example.admin.model.Product;

import java.util.List;

public interface ProductService {

    public Product addNewProduct(Product product);

    public Product findById(Long id);

    List<Product> findAllProduct();
}
