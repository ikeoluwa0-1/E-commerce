package com.davacom.thymeleafappjdbc.repository;

import com.davacom.thymeleafappjdbc.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <User, Long> {
    User findByEmailAndPassword(String email, String password);
}
