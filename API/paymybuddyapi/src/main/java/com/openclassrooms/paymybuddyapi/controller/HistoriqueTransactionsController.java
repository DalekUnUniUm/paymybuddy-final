package com.openclassrooms.paymybuddyapi.controller;

import com.openclassrooms.paymybuddyapi.model.HistoriqueTransactions;
import com.openclassrooms.paymybuddyapi.service.HistoriqueTransactionsService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@RestController
@EnableSwagger2
public class HistoriqueTransactionsController {

    @Autowired
    private HistoriqueTransactionsService historiqueTransactionsService ;

    /**Endpoint qui permet de créer un historique**/
    @ApiOperation(value = "Permet d'ajouter une opération suite à un transfert")
    @PostMapping("/historique")
    public HistoriqueTransactions createHistorique(
            @ApiParam(value = "L'Id de l'utilisateur qui fait le transfer, L'Id de l'utilisateur à qui on fait le transfer, description du transfert et le montant", required = true)
            @RequestBody HistoriqueTransactions historiqueTransactions){
        return historiqueTransactionsService.saveHistorique(historiqueTransactions);
    }
    /**Endpoint qui permet de récupérer l'historique des transactions**/
    @ApiOperation(value = "Permet de récupérer une liste d'IDs en fonction de l'Ids utilisateur")
    @GetMapping("/historique/myHistorique")
    public JSONArray getHistoriqueId(
            @ApiParam(value = "L'id de l'utilisateur", required = true)
            @RequestParam("utilisateur_id") int utilisateurId){
        return historiqueTransactionsService.getHistoriqueId(utilisateurId);
    }
    /**Endpoint qui permet de récupérer les données selon une liste d'ID**/
    @ApiOperation(value = "Permet de récupérer les données utilisateur selon une liste d'Ids")
    @RequestMapping(value = "/historiques", method = RequestMethod.GET)
    public Iterable<HistoriqueTransactions> getHistoriqueById(
            @ApiParam(value = "Une liste d'Ids", required = true)
            @RequestParam("ids") List<Long> ids){
        return historiqueTransactionsService.getHistoriqueById(ids);
    }
}
