package com.easybytes.easyschool.controller;

import com.easybytes.easyschool.model.Contact;
import com.easybytes.easyschool.proxy.ContactProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ContactController {

    @Autowired
    ContactProxy contactProxy;

    @GetMapping("/getMessages")
    public List<Contact> getMessages(@RequestParam("status") String status) {
        return contactProxy.getMessagesByStatus(status);
    }
}
