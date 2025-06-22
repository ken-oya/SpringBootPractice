package com.example.demo.controller;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.form.AdminForm;
import com.example.demo.service.AdminService;

@Controller
public class AdminSignupController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/admin/signup")
    public String showSignupForm(Model model) {
        model.addAttribute("adminForm", new AdminForm());
        return "admin/signup"; 
    }

    @PostMapping("/admin/signup")
    public String registerAdmin(
        @Valid AdminForm adminForm,
        BindingResult bindingResult,
        Model model
    ) {
        if (bindingResult.hasErrors()) {
            return "admin/signup";
        }

        adminService.register(adminForm);

        return "redirect:/admin/signin";
    }
}