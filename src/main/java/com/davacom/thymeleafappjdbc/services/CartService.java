package com.davacom.thymeleafappjdbc.services;

import com.davacom.thymeleafappjdbc.models.Cart;
import com.davacom.thymeleafappjdbc.models.Product;

import java.util.List;

public interface CartService {

     Cart findCartById(Long id);

    Product findProductById(Long id);

    Cart addToCart(Long id);

    public List<Cart> getAllCart();
}
