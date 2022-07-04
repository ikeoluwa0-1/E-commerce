package com.example.admin.service;

import com.example.admin.model.Product;

import java.util.List;

public interface UpdateProductService {
    public Product UpdateProduct(Long id);

    List<Product> getAllProduct();
}
