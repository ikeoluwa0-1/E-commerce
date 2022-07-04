package com.davacom.thymeleafappjdbc.services;

import com.davacom.thymeleafappjdbc.models.WishList;

import java.util.List;

public interface WishListService {
    WishList findListById(Long id);

    WishList addToList(Long id);

    List<WishList> getAllList();
}
