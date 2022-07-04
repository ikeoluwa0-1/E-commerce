package com.example.admin.service.serviceImpl;

import com.example.admin.model.Admin;
import com.example.admin.model.Product;
import com.example.admin.repository.ProductRepository;
import com.example.admin.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {


    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product addNewProduct(Product product) {

        product.setName(product.getName());
        product.setCategory(product.getCategory());
        product.setQuantity(product.getQuantity());
        product.setPrice(product.getPrice());
        product.setAvailable(product.getAvailable());
        productRepository.save(product);

        return product;
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findProductById(id);
    }

    @Override
    public List<Product> findAllProduct() {
        return productRepository.findAll();
    }
}
