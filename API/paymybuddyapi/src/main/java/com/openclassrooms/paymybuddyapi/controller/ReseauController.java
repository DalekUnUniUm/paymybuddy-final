package com.openclassrooms.paymybuddyapi.controller;

import com.openclassrooms.paymybuddyapi.model.Reseau;
import com.openclassrooms.paymybuddyapi.service.ReseauService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@EnableSwagger2
public class ReseauController {

    @Autowired
    private ReseauService reseauService ;

    /**Endpoint qui permet d'ajouter deux amis**/
    @ApiOperation(value = "Permet d'ajouter deux amis")
    @PostMapping("/reseau")
    public Reseau addFriend(
            @ApiParam(value = "userA = celui qui ajoute, userB = celui qui est ajouté",required = true)
            @RequestBody Reseau reseau){
        return reseauService.saveReseau(reseau) ;
    }

    /**Endpoint qui permet d'avoir le nombre d'ami selon l'ID de l'utilisateur**/
    @ApiOperation(value = "Permet de récupérer le nombre d'ami")
    @GetMapping("/reseau/nbrFriends")
    public int nbrAmi(
            @ApiParam(value = "L'Id de l'utilisateur",required = true)
            @RequestParam("userId") int userId){
        return reseauService.nbrAmis(userId);
    }

    /**Endpoint qui permet de savoir si deux personnes sont déjà amis**/
    @ApiOperation(value = "Permet de savoir si deux personnes sont déjà amis")
    @GetMapping("/reseau/isFriends")
    public int isFriends(
            @ApiParam(value = "Les Id de l'utilisateur qui veut ajouter et celui qui est ajouté, le sens n'a pas d'importance",required = true)
            @RequestParam("userAId") String userAId, @RequestParam("userBId") String userBId){
        return reseauService.isFriends(userAId,userBId);
    }

    /**Endpoint qui permet de récupérer la liste des prénoms de ses amis**/
    @ApiOperation(value = "Permet de récupérer la liste d'ami")
    @GetMapping("/reseau/listFriendsFirstName")
    public JSONObject listFriendsFirstName(
            @ApiParam(value = "L'Id de l'utilisateur",required = true)
            @RequestParam("utilisateur_id") int utilisateurId){
        JSONObject listFriend = new JSONObject();

        listFriend.put("firstName",reseauService.listFriendsFirstName(utilisateurId));

        return listFriend;
    }

}
