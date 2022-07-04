package com.example.admin.service.serviceImpl;

import com.example.admin.model.Product;
import com.example.admin.repository.DeleteProductRepository;
import com.example.admin.service.DeleteProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteProductServiceImpl implements DeleteProductService {

    @Autowired
    private DeleteProductRepository deleteProductRepository;

    @Override
    public Product deleteProduct(Long id){
        Product product = deleteProductRepository.findProductById(id);
        deleteProductRepository.delete(product);

        return product;
    }
}
