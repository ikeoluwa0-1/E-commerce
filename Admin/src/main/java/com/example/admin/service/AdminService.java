package com.example.admin.service;

import com.example.admin.model.Admin;
import org.springframework.stereotype.Service;


public interface AdminService {

    public Admin login(String email, String password);

    public Admin findByEmailAndPassword(String email, String password);

}


