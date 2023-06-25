package com.easybytes.easyschool.service;

import com.easybytes.easyschool.constants.EazySchoolConstants;
import com.easybytes.easyschool.model.BaseEntity;
import com.easybytes.easyschool.model.Contact;
import com.easybytes.easyschool.repository.ContactRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class ContactService {

    // This will invoke the ContactRepository from service layer
    @Autowired
    private ContactRepository contactRepository;

    public ContactService() {
        log.info("Contact service bean is initialized");
    }

    public boolean saveMessageDetails(Contact contact) {
        boolean isSaved = false;

        BaseEntity baseEntity = new BaseEntity(LocalDateTime.now(), EazySchoolConstants.ANONYMOUS,
                null, null);

        Contact contact1 = new Contact(contact.contactId(), contact.name(), contact.mobileNum(),
                contact.email(), contact.subject(), contact.message(), EazySchoolConstants.OPEN, baseEntity);

        int result = contactRepository.saveContactMsg(contact1);
        if (result > 0) {
            isSaved = true;
        }

        return isSaved;
    }

    public List<Contact> findMsgsWithOpenStatus() {
        return contactRepository.findMsgsWithStatus(EazySchoolConstants.OPEN);
    }
}
