package com.openclassrooms.paymybuddyapi.repository;

import com.openclassrooms.paymybuddyapi.model.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Long> {

}
