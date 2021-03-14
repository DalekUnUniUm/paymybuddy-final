package com.openclassrooms.paymybuddyapi.controller;

import com.openclassrooms.paymybuddyapi.model.Contact;
import com.openclassrooms.paymybuddyapi.service.ContactService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@EnableSwagger2
public class ContactController {

    @Autowired
    private ContactService contactService ;

    /**Endpoint qui permet d'ajouter un ticket pour le support**/
    @ApiOperation(value = "Ajouter un ticket pour le support")
    @PostMapping("/contact")
    public Contact createTicket(
            @ApiParam(value = "Prenom, Mail, et descriptif du probleme requis", required = true)
            @RequestBody Contact contact){
        return contactService.saveContact(contact);
    }

}
