package com.easybytes.easyschool.service;

import com.easybytes.easyschool.model.Contact;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ContactService {

    public boolean saveMessageDetails(Contact contact) {
        boolean isSaved = true;

        log.info(contact.toString());

        return isSaved;
    }
}
