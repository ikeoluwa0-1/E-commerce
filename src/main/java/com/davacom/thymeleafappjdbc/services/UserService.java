package com.davacom.thymeleafappjdbc.services;


import com.davacom.thymeleafappjdbc.models.User;
import com.davacom.thymeleafappjdbc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User login(String email, String password) {
        User user = userRepository.findByEmailAndPassword(email, password);
        return user;
    }


    public User create(User userDto) {
        User user = User.builder()
                .fullName(userDto.getFullName())
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .build();
        return userRepository.save(user);
    }


     public List<User> getAllUsers () {
        return userRepository.findAll();
    }

}
