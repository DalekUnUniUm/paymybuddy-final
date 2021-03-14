package com.openclassrooms.paymybuddyapi.service;

import com.openclassrooms.paymybuddyapi.model.PorteMonnaie;
import com.openclassrooms.paymybuddyapi.repository.PorteMonnaieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class PorteMonnaieService {

    @Autowired
    private PorteMonnaieRepository porteMonnaieRepository ;

    /**Endpoint qui permet la création d'un porte monnaie lors de l'enregistrement d'une personne**/
    @Transactional(rollbackFor = Exception.class)
    public PorteMonnaie savePorteMonnaie(PorteMonnaie porteMonnaie){
        PorteMonnaie savedPorteMonnaie = porteMonnaieRepository.save(porteMonnaie);
        return savedPorteMonnaie ;
    }
    /**Permet d'associer un compte en banque**/
    @Transactional(rollbackFor = Exception.class)
    public void updateBankAccount(String bankAccount, int porteMonnaieId){
        porteMonnaieRepository.updateBankAccount(bankAccount,porteMonnaieId);
    }
    /**Permet de récupérer le numéro du compte en banque**/
    public String getBankAccount(int soldesId){
        return porteMonnaieRepository.getBankAccount(soldesId);
    }

    /**Endpoint qui permet de récupérer le solde selon l'ID de soldes_id dans la table utilisateur**/
    public double getSoldes(int soldesID){
        return porteMonnaieRepository.getSoldes(soldesID);
    }

    /**Endpoint qui permet de d'ajouter de l'argent selon l'ID de soldes_id dans la table utilisateur**/
    @Transactional(rollbackFor = Exception.class)
    public void updateSoldesAdd(double addSoldes, int porteMonnaieId){
        porteMonnaieRepository.updateSoldesAdd(addSoldes, porteMonnaieId);
    }
    @Transactional(rollbackFor = Exception.class)
    public void updateSoldesSoustract(double soustractSoldes, int porteMonnaieId){
        porteMonnaieRepository.updateSoldesSoustract(soustractSoldes, porteMonnaieId);
    }
}
