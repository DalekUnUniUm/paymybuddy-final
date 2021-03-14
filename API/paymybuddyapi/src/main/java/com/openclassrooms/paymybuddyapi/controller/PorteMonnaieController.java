package com.openclassrooms.paymybuddyapi.controller;

import com.openclassrooms.paymybuddyapi.model.PorteMonnaie;
import com.openclassrooms.paymybuddyapi.service.PorteMonnaieService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@EnableSwagger2
public class PorteMonnaieController {

    @Autowired
    private PorteMonnaieService porteMonnaieService ;

    /**Endpoint qui permet la création d'un porte monnaie lors de l'enregistrement d'une personne**/
    @ApiOperation(value = "Création d'un porte monnaie lors de l'enregistrement d'un nouvel utilisateur")
    @PostMapping("/wallet")
    public PorteMonnaie createPorteMonnaie(
            @ApiParam(value = "Soldes = 0.0, Bank Account = 0, Available = true (passera false une fois associé à un compte", required = true)
            @RequestBody PorteMonnaie porteMonnaie){
        return porteMonnaieService.savePorteMonnaie(porteMonnaie);
    }
    /**Permet d'associer un compte en banque**/
    @ApiOperation(value = "Permet l'ajout d'un compte bancaire pour un compte")
    @PutMapping("/wallet/bankaccount")
    public void updateBankAccount(
            @ApiParam(value = "Numéro compte bancaire 11 chiffres, et l'id associé à un utilisateur", required = true)
            @RequestParam("bankaccount") String bankAccount, @RequestParam("soldesId") int porteMonnaieId){
        porteMonnaieService.updateBankAccount(bankAccount,porteMonnaieId);
    }
    /**Permet de récupérer le numéro du compte en banque**/
    @ApiOperation(value = "Permet de récupérer un compte en banque (seulement pour un test, ne dois jamais être affiché !)")
    @GetMapping("/wallet/getBankAccount")
    public String getBankAccount(
            @ApiParam(value = "L'Id associé a un compte utilisateur", required = true)
            @RequestParam("soldesId") int porteMonnaieId){
        return porteMonnaieService.getBankAccount(porteMonnaieId);
    }
    /**Endpoint qui permet de récupérer le soldes selon l'ID de soldes_id dans la table utilisateur**/
    @ApiOperation(value = "Permet de récupérer le solde d'un compte")
    @GetMapping("/wallet/soldes")
    public double getSoldes(
            @ApiParam(value = "L'id associé à un compte utilisateur", required = true)
            @RequestParam("soldesId") int soldesId){
        return porteMonnaieService.getSoldes(soldesId);
    }

    /**Endpoint qui permet de d'ajouter de l'argent selon l'ID de soldes_id dans la table utilisateur**/
    @ApiOperation(value = "Permet d'ajouter de l'argent à un compte")
    @PutMapping("/wallet/updateSoldesAdd")
    public void updateSoldesAdd(
            @ApiParam(value = "Le montant et l'id associé à un compte utilisateur")
            @RequestParam("addSoldes") int addSoldes, @RequestParam("soldesId") int porteMonnaieId){
        porteMonnaieService.updateSoldesAdd(addSoldes,porteMonnaieId);
    }

    /**Endpoint qui permet de d'enelver de l'argent selon l'ID de soldes_id dans la table utilisateur**/
    @ApiOperation(value = "Permet d'enlever de l'argent à un compte")
    @PutMapping("/wallet/updateSoldesSoustract")
    public void updateSoldesSoustract(
            @ApiParam(value = "Le montant et l'id associé à un compte utilisateur")
            @RequestParam("soustractSoldes") int soustractSoldes, @RequestParam("soldesId") int porteMonnaieId){
        porteMonnaieService.updateSoldesSoustract(soustractSoldes,porteMonnaieId);
    }
}
