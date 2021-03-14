package com.openclassrooms.paymybuddyapi.repository;

import com.openclassrooms.paymybuddyapi.model.Utilisateur;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UtilisateurRepository extends CrudRepository<Utilisateur, Long> {

    @Query(value = "SELECT mail FROM utilisateurs u WHERE u.mail = :mail", nativeQuery = true)
    String findUserByMail(@Param("mail") String mail);

    /**Permet de trouver l'ID via une combinaison de mail et mot de passe, utilisé pour le login**/
    @Query(value = "SELECT utilisateur_id FROM utilisateurs u WHERE u.mail = :mail AND u.password = :password", nativeQuery = true)
    String findIdByMailAndPwd(@Param("mail") String mail, @Param("password") String password);

    /**Permet de trouver l'ID avec un email, servira pour l'ajout d'ami, et les transactions d'argent**/
    @Query(value = "SELECT utilisateur_id FROM utilisateurs u WHERE u.mail = :mail", nativeQuery = true)
    String findIdByMail(@Param("mail") String mail);

    /**Permet de trouver un mot de passer via un email, utilisé pour comparer un mot de passe externe avec un mot de passe de la base de données**/
    @Query(value = "SELECT password FROM utilisateurs u WHERE u.mail = :mail", nativeQuery = true)
    String findPwdByMail(@Param("mail") String mail);

    /**Permet de récupérer l'ID en fonction du prénom**/
    @Query(value = "SELECT utilisateur_id FROM utilisateurs u WHERE u.prenom = :firstname", nativeQuery = true)
    String utilisateurIdByName(@Param("firstname") String firstName);

    /**Permet de récupérer le soldes ID en fonction de l'utilisateur de l'ID**/
    @Query(value = "SELECT soldes_id FROM utilisateurs u WHERE u.utilisateur_id = :utilisateurId", nativeQuery = true)
    String soldesIdByUserId(@Param("utilisateurId") String utilisateurId);

    @Query(value = "SELECT prenom FROM utilisateurs u WHERE u.utilisateur_id = :utilisateurId", nativeQuery = true)
    String firstNameByUserId(@Param("utilisateurId") String utilisateurId);
}
