package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Contact;
import com.example.demo.form.ContactForm;
import com.example.demo.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {
    @Autowired
      private ContactRepository contactRepository;

    @Override
    public void saveContact(ContactForm contactForm) {
        Contact contact = new Contact();

        contact.setLastName(contactForm.getLastName());
        contact.setFirstName(contactForm.getFirstName());
        contact.setEmail(contactForm.getEmail());
        contact.setPhone(contactForm.getPhone());
        contact.setZipCode(contactForm.getZipCode());
        contact.setAddress(contactForm.getAddress());
        contact.setBuildingName(contactForm.getBuildingName());
        contact.setContactType(contactForm.getContactType());
        contact.setBody(contactForm.getBody());
        contact.setCreatedAt(LocalDateTime.now());

        contactRepository.save(contact);
    }
    
    @Override
    public List<Contact> getAllContacts(){
    	return contactRepository.findAll();
    }
    
    @Override
    public Contact findById(Long id) {
        return contactRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("指定されたお問い合わせが見つかりません"));
    }
    
    @Override
    public Contact getContactById(Long id) {
        return contactRepository.findById(id).orElse(null);
    }
    
    @Override
    public void updateContact(Long id, Contact updatedContact) {
        Contact existing = contactRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setLastName(updatedContact.getLastName());
            existing.setFirstName(updatedContact.getFirstName());
            existing.setEmail(updatedContact.getEmail());
            existing.setPhone(updatedContact.getPhone());
            existing.setZipCode(updatedContact.getZipCode());
            existing.setAddress(updatedContact.getAddress());
            existing.setBuildingName(updatedContact.getBuildingName());
            existing.setContactType(updatedContact.getContactType());
            existing.setBody(updatedContact.getBody());
            existing.setUpdatedAt(LocalDateTime.now());
            contactRepository.save(existing);
        }
    }
    
    @Override
    public void deleteContact(Long id) {
        contactRepository.deleteById(id);
    }
}