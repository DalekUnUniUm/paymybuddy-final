package com.openclassrooms.paymybuddyapi.service;

import com.openclassrooms.paymybuddyapi.model.Utilisateur;
import com.openclassrooms.paymybuddyapi.repository.UtilisateurRepository;
import jdk.jshell.execution.Util;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Data
@Service
public class UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository ;

    /**Endpoint qui permet d'enregistrer un nouvelle utilisateur**/
    @Transactional(rollbackFor = Exception.class)
    public Utilisateur saveUtilisateur(Utilisateur utilisateur){
        Utilisateur savedUtilisateur = utilisateurRepository.save(utilisateur);
        return savedUtilisateur ;
    }
    /** Endpoint de login?mail=<mail>&password=<password>**/
    public String loginUser(String mail, String password){
        return utilisateurRepository.findIdByMailAndPwd(mail,password);
    }
    /**Cet endpoint permet de récupérer l'Id d'un utilisateur selon mail**/
    public String findIdByMail(String mail){
        return utilisateurRepository.findIdByMail(mail);
    }
    /**Endpoint qui permet de récuperer tout les utilisateurs de la base de données**/
    public Iterable<Utilisateur> getUtilisateurs(){
        return utilisateurRepository.findAll();
    }
    /**Endpoint qui permet de récuperer un utilisateur de la base de données selon son ID**/
    public Optional<Utilisateur> getUtilisateur(final long id){
        return utilisateurRepository.findById(id);
    }
    /**Permet de récupérer l'ID en fonction du prénom**/
    public String utilisateurIdByName(String firstName){
        return utilisateurRepository.utilisateurIdByName(firstName);
    }
    /**Permet de récupérer le soldes ID en fonction de l'utilisateur de l'ID**/
    public String soldesIdByUserId(String utilisateurId){
        return utilisateurRepository.soldesIdByUserId(utilisateurId);
    }
    /**Permet de récupérer le prénom selon un Id**/
    public String firstNameByUserId(String utilisateurId){
        return utilisateurRepository.firstNameByUserId(utilisateurId);
    }

}
