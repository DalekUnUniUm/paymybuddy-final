package com.openclassrooms.paymybuddyapi.controller;

import com.openclassrooms.paymybuddyapi.model.Utilisateur;
import com.openclassrooms.paymybuddyapi.service.PorteMonnaieService;
import com.openclassrooms.paymybuddyapi.service.UtilisateurService;
import com.openclassrooms.paymybuddyapi.utils.CheckingDataBaseUtils;
import com.openclassrooms.paymybuddyapi.utils.PasswordUtils;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import jdk.jshell.execution.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService ;
    @Autowired
    private CheckingDataBaseUtils checkingDataBaseUtils ;
    @Autowired
    private PasswordUtils passwordUtils;


    /**Endpoint qui permet d'enregistrer un nouvelle utilisateur**/
    @ApiOperation(value = "Permet d'enregistrer un nouvel utilisateur")
    @PostMapping("/utilisateur/register")
    public Utilisateur createUser(
            @ApiParam(value = "Nom, prenom, mail, mot de passe", required = true)
            @RequestBody Utilisateur utilisateur){
        utilisateur.setSoldesId(checkingDataBaseUtils.primaryKeyPorteMonnaie());
        utilisateur.setPassword(passwordUtils.hashPassword(utilisateur.getPassword()));
        return utilisateurService.saveUtilisateur(utilisateur);
    }
    /** Endpoint de login?mail=<mail>&password=<password>**/
    @ApiOperation(value = "Permet de se connecter a l'application")
    @RequestMapping(value = "/utilisateur/login", method = RequestMethod.GET)
    public String loginUser(
            @ApiParam(value = "Combinaison mail + mot de passe", required = true)
            @RequestParam("mail") String mail, @RequestParam("password") String password){

        String hshPwd = passwordUtils.getPasswordFromDb(password,mail);
        return utilisateurService.loginUser(mail,hshPwd);
    }
    /**Cet endpoint permet de r??cup??rer l'Id d'un utilisateur selon mail**/
    @ApiOperation(value = "Permet de r??cup??rer l'id de l'utilisateur selon son mail")
    @RequestMapping(value = "/utilisateur", method = RequestMethod.GET)
    public String findIdByMail(
            @ApiParam(value = "Addresse mail de l'utilisateur", required = true)
            @RequestParam("mail") String mail){
        return utilisateurService.findIdByMail(mail);
    }
    /**Endpoint qui permet de r??cuperer tout les utilisateurs de la base de donn??es**/
    @ApiOperation(value = "Permet de r??cuperer tout les utilisateurs de la base de donn??es")
    @GetMapping("/utilisateurs")
    public Iterable<Utilisateur> getUtilisateurs() {
        return utilisateurService.getUtilisateurs();
    }
    /**Endpoint qui permet de r??cuperer un utilisateur de la base de donn??es selon son ID**/
    @ApiOperation(value = "Permet de r??cup??rer les donn??es d'un utilisateur selon son Id")
    @GetMapping("/utilisateur/{id}")
    public Optional<Utilisateur> getUtilisataur(
            @ApiParam(value = "L'id de l'utilisateur", required = true)
            @PathVariable("id") final Long id){
        return utilisateurService.getUtilisateur(id);
    }
    /**Permet de r??cup??rer l'ID en fonction du pr??nom**/
    @ApiOperation(value = "Permet de r??cup??rer l'Id d'un utilisateur selon son pr??nom")
    @GetMapping(value = "/utilisateurIdByName")
    public String utilisateurIdByName(@RequestParam("firstName") String firstName){
        return utilisateurService.utilisateurIdByName(firstName);
    }
    /**Permet de r??cup??rer le soldes ID en fonction de l'utilisateur de l'ID**/
    @ApiOperation(value = "Permet de r??cup??rer le soldes ID (porte monnaie) selon l'id d'un utilisateur")
    @GetMapping(value = "/utilisateur/soldesIdById")
    public String soldesIdByUserId(
            @ApiParam(value = "L'id de l'utilisateur", required = true)
            @RequestParam("utilisateurId") String utilisateurId){
        return utilisateurService.soldesIdByUserId(utilisateurId);
    }
    /**Permet de r??cup??rer le pr??nom selon un Id**/
    @ApiOperation(value = "Permet de r??cup??rer le pr??nom selon un Id")
    @GetMapping(value = "/utilisateur/firstNameById")
    public String firstNameByUserId(
            @ApiParam(value = "L'id de l'utilisateur", required = true)
            @RequestParam("utilisateurId") String utilisateurId){
        return utilisateurService.firstNameByUserId(utilisateurId);
    }
}
