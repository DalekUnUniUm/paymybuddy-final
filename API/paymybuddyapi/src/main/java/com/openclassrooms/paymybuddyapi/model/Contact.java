package com.openclassrooms.paymybuddyapi.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "contact")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contactId ;

    @Column(name = "first_name")
    private String firstName ;

    @Column(name = "email")
    private String email ;

    @Column(name = "problems")
    private String problem ;
}
