package com.openclassrooms.paymybuddyapi.service;

import com.openclassrooms.paymybuddyapi.model.Contact;
import com.openclassrooms.paymybuddyapi.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository ;

    /**Endpoint qui permet d'ajouter un ticket pour le support**/
    @Transactional(rollbackFor = Exception.class)
    public Contact saveContact(Contact contact){
        System.out.println("Je viens là ?");
        Contact savedContact = contactRepository.save(contact);
        return savedContact ;
    }

}
