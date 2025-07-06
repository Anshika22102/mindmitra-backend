package com.mindmitra.backend.service;

import com.mindmitra.backend.model.EmergencyContact;
import com.mindmitra.backend.repository.ContactRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    private final ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public EmergencyContact saveContact(EmergencyContact contact) {
        return contactRepository.save(contact);
    }

    public List<EmergencyContact> getContactsByUserId(String userId) {
        return contactRepository.findByUserId(userId);
    }
}
