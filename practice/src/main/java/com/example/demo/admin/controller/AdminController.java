package com.example.demo.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Contact;
import com.example.demo.service.ContactService;

@Controller
public class AdminController {

    @Autowired
    private ContactService contactService;

    @GetMapping("/admin/contacts")
    public String contactList(Model model) {
        List<Contact> contacts = contactService.getAllContacts();
        model.addAttribute("contacts", contacts);
        return "admin/contactList";
    }
    
    @GetMapping("/admin/contacts/{id}")
    public String contactDetail(@PathVariable Long id, Model model) {
        Contact contact = contactService.findById(id);
        model.addAttribute("contact", contact);
        return "admin/contactDetail";
    }
    
    @GetMapping("/admin/contacts/{id}/edit")
    public String editContact(@PathVariable Long id, Model model) {
        Contact contact = contactService.getContactById(id);
        model.addAttribute("contact", contact);
        return "admin/editContact";
    }
    
    @PostMapping("/admin/contacts/{id}/edit")
    public String updateContact(@PathVariable Long id, @ModelAttribute Contact updatedContact) {
        contactService.updateContact(id, updatedContact);
        return "redirect:/admin/contacts";
    }
    
    @PostMapping("/admin/contacts/{id}/delete")
    public String deleteContact(@PathVariable Long id) {
        contactService.deleteContact(id);
        return "redirect:/admin/contacts";
    }
}