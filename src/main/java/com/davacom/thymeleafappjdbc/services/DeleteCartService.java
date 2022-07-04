package com.davacom.thymeleafappjdbc.services;

import com.davacom.thymeleafappjdbc.models.Cart;

public interface DeleteCartService{
    Cart deleteCart(Long id);
}
