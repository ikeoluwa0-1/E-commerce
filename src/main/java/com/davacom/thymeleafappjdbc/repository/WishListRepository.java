package com.davacom.thymeleafappjdbc.repository;

import com.davacom.thymeleafappjdbc.models.WishList;
import lombok.Setter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface WishListRepository extends JpaRepository<WishList, Long> {
    WishList findWishListById(Long id);
}
