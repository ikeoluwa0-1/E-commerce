package com.example.admin.service.serviceImpl;

import com.example.admin.model.Admin;
import com.example.admin.repository.AdminRepository;
import com.example.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


    @Service
    public class AdminServiceImpl implements AdminService {

        @Autowired
        private AdminRepository adminRepository;

        @Override
        public Admin login(String email, String password) {
        Admin admin = adminRepository.findAdminByEmailAndPassword(email, password);
        return admin;
    }

        @Override
        public Admin findByEmailAndPassword(String email, String password) {
            return adminRepository.findAdminByEmailAndPassword(email, password);
        }
    }
