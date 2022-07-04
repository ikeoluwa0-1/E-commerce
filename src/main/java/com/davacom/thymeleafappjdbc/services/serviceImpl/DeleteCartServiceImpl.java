package com.davacom.thymeleafappjdbc.services.serviceImpl;

import com.davacom.thymeleafappjdbc.models.Cart;
import com.davacom.thymeleafappjdbc.models.Product;
import com.davacom.thymeleafappjdbc.repository.CartRepository;
import com.davacom.thymeleafappjdbc.repository.ProductRepository;
import com.davacom.thymeleafappjdbc.services.DeleteCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DeleteCartServiceImpl implements DeleteCartService {

    @Autowired
    private CartRepository cartRepository;

    @Override
    public Cart deleteCart(Long id){
        Cart cart = cartRepository.findCartById(id);
        cartRepository.delete(cart);
        return cart;


    }
}
