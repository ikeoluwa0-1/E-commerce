package com.davacom.thymeleafappjdbc.services.serviceImpl;

import com.davacom.thymeleafappjdbc.models.Product;
import com.davacom.thymeleafappjdbc.repository.ProductRepository;
import com.davacom.thymeleafappjdbc.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImp implements ProductService {

    @Autowired
    ProductRepository productRepository;



    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }
}
