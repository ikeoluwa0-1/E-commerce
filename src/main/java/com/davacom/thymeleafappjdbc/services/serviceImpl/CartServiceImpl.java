package com.davacom.thymeleafappjdbc.services.serviceImpl;

import com.davacom.thymeleafappjdbc.models.Cart;
import com.davacom.thymeleafappjdbc.models.Product;
import com.davacom.thymeleafappjdbc.repository.CartRepository;
import com.davacom.thymeleafappjdbc.repository.ProductRepository;
import com.davacom.thymeleafappjdbc.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Cart findCartById(Long id){ return cartRepository.findCartById(id);}

    @Override
    public Product findProductById(Long id) { return productRepository.findProductById(id);}

    @Override
    public Cart addToCart(Long id) {
        Product product = productRepository.findProductById(id);
            Cart cart = new Cart();
            cart.setId(product.getId());
            cart.setName(product.getName());
            cart.setCategory(product.getCategory());
            cart.setPrice(product.getPrice());
            cart.setQuantity(product.getQuantity());
            cartRepository.save(cart);
            return cart;
    }

    @Override
    public List<Cart> getAllCart() {
        return  cartRepository.findAll();
    }
}
