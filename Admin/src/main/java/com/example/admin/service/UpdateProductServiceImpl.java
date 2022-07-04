package com.example.admin.service;

import com.example.admin.model.Product;
import com.example.admin.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UpdateProductServiceImpl implements UpdateProductService{

    @Autowired
    ProductRepository productRepository;

    @Override
    public Product UpdateProduct(Long id){
        Product product = new Product();

        product.setId(product.getId());
        product.setName(product.getName());
        product.setCategory(product.getCategory());
        product.setPrice(product.getPrice());
        product.setAvailable(product.getAvailable());
        product.setQuantity(product.getQuantity());
        productRepository.save(product);
            return product;
    }


    @Override
    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }
}
