package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Admin;
import com.example.demo.form.AdminForm;
import com.example.demo.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void register(AdminForm adminForm) {
        Admin admin = new Admin();

        admin.setFirstName(adminForm.getFirstName());
        admin.setLastName(adminForm.getLastName());
        admin.setEmail(adminForm.getEmail());

        String encodedPassword = passwordEncoder.encode(adminForm.getPassword());
        admin.setPassword(encodedPassword);

        adminRepository.save(admin);
    }
}