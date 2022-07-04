package com.davacom.thymeleafappjdbc.repository;

import com.davacom.thymeleafappjdbc.models.Cart;
import lombok.Setter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface CartRepository extends JpaRepository <Cart, Long>{
    Cart findCartById(Long id);
}
