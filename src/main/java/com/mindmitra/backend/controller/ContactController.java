package com.mindmitra.backend.controller;

import com.mindmitra.backend.model.EmergencyContact;
import com.mindmitra.backend.service.ContactService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/contacts")
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping
    public EmergencyContact addContact(@RequestBody EmergencyContact contact) {
        return contactService.saveContact(contact);
    }

    @GetMapping("/{userId}")
    public List<EmergencyContact> getContacts(@PathVariable String userId) {
        return contactService.getContactsByUserId(userId);
    }
}
