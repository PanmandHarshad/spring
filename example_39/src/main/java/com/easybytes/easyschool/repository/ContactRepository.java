package com.easybytes.easyschool.repository;

import com.easybytes.easyschool.model.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Repository stereotype annotation is used to add a bean of this class
 * type to the Spring context and indicate that given Bean is used to perform
 * DB related operations and
 */
@Repository
public interface ContactRepository extends CrudRepository<Contact, Integer> {

    // This is a derived query.
    List<Contact> findByStatus(String status);
}
