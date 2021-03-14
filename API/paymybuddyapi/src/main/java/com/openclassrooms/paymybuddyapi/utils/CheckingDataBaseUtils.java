package com.openclassrooms.paymybuddyapi.utils;

import com.openclassrooms.paymybuddyapi.repository.PorteMonnaieRepository;
import com.openclassrooms.paymybuddyapi.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class CheckingDataBaseUtils {

    @Autowired
    private UtilisateurRepository utilisateurRepository ;

    @Autowired
    private PorteMonnaieRepository porteMonnaieRepository ;

    /**Fonctionne générique qui permet de savoir si un utilisateur est dans la base de données utilisateurs**/
    public boolean utilisateurExist(String mail){

        if(utilisateurRepository.findUserByMail(mail) == null)
            return false;

        return true ;
    }

    /**Fonction qui permet de récuperer l'ID d'un porte monnaie disponible, pour l'assigner à un utilisateur**/
    @Transactional
    public int primaryKeyPorteMonnaie(){
        int key = porteMonnaieRepository.findIdByAvailable(true) ;
        porteMonnaieRepository.updateAvailablePorteMonnaie(key);
        return key ;
    }

}
