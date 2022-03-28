package com.example.springswaggertest;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@RestController
public class AddressBook {

    ConcurrentMap<String, Contact> contacts = new ConcurrentHashMap<>();
    @GetMapping("/{id}")
    public Contact getContact(@PathVariable String id) {
        return contacts.get(id);
    }
    @GetMapping("/")
    public List<Contact> getAllContacts() {
        return new ArrayList<>(contacts.values());
    }
    @PostMapping("/")
    public Contact addContact(@RequestBody Contact contact) {
        contacts.put(contact.getId(), contact);
        return contact;
    }


}
