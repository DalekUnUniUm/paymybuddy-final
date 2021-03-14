package com.openclassrooms.paymybuddyapi.repository;

import com.openclassrooms.paymybuddyapi.model.HistoriqueTransactions;
import org.json.simple.JSONArray;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoriqueTransactionsRepository extends CrudRepository<HistoriqueTransactions, Long> {

    @Query(value = "SELECT historique_transactions_id FROM historique_transaction  WHERE  historique_transaction.utilisateur_id = :utilisateur_id", nativeQuery = true)
    JSONArray getHistoriqueId(@Param("utilisateur_id") int utilisateurId);
}
