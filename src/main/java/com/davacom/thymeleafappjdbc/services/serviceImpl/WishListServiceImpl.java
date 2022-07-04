package com.davacom.thymeleafappjdbc.services.serviceImpl;

import com.davacom.thymeleafappjdbc.models.Product;
import com.davacom.thymeleafappjdbc.models.WishList;
import com.davacom.thymeleafappjdbc.repository.CartRepository;
import com.davacom.thymeleafappjdbc.repository.ProductRepository;
import com.davacom.thymeleafappjdbc.repository.WishListRepository;
import com.davacom.thymeleafappjdbc.services.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishListServiceImpl implements WishListService {

    @Autowired
    private WishListRepository wishListRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public WishList findListById(Long id){ return wishListRepository.findWishListById(id);}

    @Override
    public WishList addToList(Long id){
        Product product = productRepository.findProductById(id);
        WishList list = new WishList();
        list.setId(product.getId());
        list.setName(product.getName());
        list.setPrice(product.getPrice());
        list.setCategory(product.getCategory());
        list.setQuantity(product.getQuantity());
        wishListRepository.save(list);
        return list;
    }

    @Override
    public List<WishList> getAllList(){return wishListRepository.findAll();}
}
