package com.easybytes.easyschool.repository;

import com.easybytes.easyschool.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @Repository stereotype annotation is used to add a bean of this class
 * type to the Spring context and indicate that given Bean is used to perform
 * DB related operations and
 */
@Repository
public class ContactRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ContactRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int saveContactMsg(Contact contact) {
        String sql = "INSERT INTO CONTACT_MSG (NAME, MOBILE_NUM, EMAIL, SUBJECT, MESSAGE, STATUS, CREATED_AT, CREATED_BY)" +
                " VALUES (?,?,?,?,?,?,?,?)";

        return jdbcTemplate.update(sql, contact.name(), contact.mobileNum(), contact.email(), contact.subject(),
                contact.message(), contact.status(), contact.baseEntity().createdAt(), contact.baseEntity().createdBy());
    }
}
