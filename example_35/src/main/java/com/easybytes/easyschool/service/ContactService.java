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
import java.util.Optional;

@Slf4j
@Service
public class ContactService {

    // This will invoke the ContactRepository from service layer
    @Autowired
    private ContactRepository contactRepository;

    public boolean saveMessageDetails(Contact contact) {
        boolean isSaved = false;

        BaseEntity baseEntity = new BaseEntity(LocalDateTime.now(), EazySchoolConstants.ANONYMOUS,
                null, null);

        Contact contact1 = new Contact(contact.contactId(), contact.name(), contact.mobileNum(),
                contact.email(), contact.subject(), contact.message(), EazySchoolConstants.OPEN, baseEntity);

        Contact savedContact = contactRepository.save(contact1);
        if (savedContact.contactId() > 0) {
            isSaved = true;
        }

        return isSaved;
    }

    public List<Contact> findMsgsWithOpenStatus() {
        return contactRepository.findByStatus(EazySchoolConstants.OPEN);
    }

    public boolean updateMsgStatus(int contactId, String updatedBy) {
        boolean isUpdated = false;

        Optional<Contact> contact = contactRepository.findById(contactId);
        if (contact.isPresent()) {
            Contact contact1 = contact.get();
            BaseEntity baseEntity = new BaseEntity(contact1.baseEntity().createdAt(),
                    contact1.baseEntity().createdBy(),
                    LocalDateTime.now(),
                    updatedBy);

            Contact contactToUpdate = new Contact(
                    contact1.contactId(),
                    contact1.name(),
                    contact1.mobileNum(),
                    contact1.email(),
                    contact1.subject(),
                    contact1.message(),
                    EazySchoolConstants.CLOSE,
                    baseEntity);

            Contact updatedContact = contactRepository.save(contactToUpdate);

            if (updatedContact.baseEntity().updatedBy() != null) {
                isUpdated = true;
            }
        }

        return isUpdated;
    }
}
