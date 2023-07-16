package com.easybytes.easyschool.repository;

import com.easybytes.easyschool.model.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Repository stereotype annotation is used to add a bean of this class
 * type to the Spring context and indicate that given Bean is used to perform
 * DB related operations and
 */
@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {

    // This is a derived query.
    List<Contact> findByStatus(String status);

    //@Query("SELECT c FROM Contact c Where c.status= :status") // JPQL
    @Query(value = "SELECT * FROM contact_msg c WHERE c.status = :status", nativeQuery = true) // Native query
    Page<Contact> findByStatus(@Param("status") String status, Pageable pageable);

    @Transactional
    @Modifying
    // ?1 mapping to first parameter of method and ?2 mapping to second parameter of the method
    @Query("UPDATE Contact c SET c.status = ?1 WHERE c.contactId = ?2") // JPQL
    int updateStatusById(String status, int id);

    Page<Contact> findOpenMsgs(@Param("status") String status, Pageable pageable);

    @Transactional
    @Modifying
    int updateMsgStatus(String status, int id);

    @Query(nativeQuery = true)
    Page<Contact> findOpenMsgsNative(@Param("status") String status, Pageable pageable);

    @Transactional
    @Modifying
    @Query(nativeQuery = true)
    int updateMsgStatusNative(String status, int id);
}
