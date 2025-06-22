package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.form.AdminForm;

@Controller
public class AdminSigninController {

    @GetMapping("/admin/signin")
    public String showSigninForm(Model model) {
        model.addAttribute("adminForm", new AdminForm());
        return "admin/signin";
    }
}