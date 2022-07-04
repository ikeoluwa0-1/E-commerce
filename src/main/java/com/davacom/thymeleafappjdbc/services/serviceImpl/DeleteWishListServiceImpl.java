package com.davacom.thymeleafappjdbc.services.serviceImpl;

import com.davacom.thymeleafappjdbc.models.WishList;
import com.davacom.thymeleafappjdbc.repository.WishListRepository;
import com.davacom.thymeleafappjdbc.services.DeleteWishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteWishListServiceImpl implements DeleteWishListService {

    @Autowired
    WishListRepository wishListRepository;


    @Override
    public WishList DeleteWishListService(Long id) {
        WishList wishList = wishListRepository.findWishListById(id);
        wishListRepository.delete(wishList);

        return wishList;
    }
}

