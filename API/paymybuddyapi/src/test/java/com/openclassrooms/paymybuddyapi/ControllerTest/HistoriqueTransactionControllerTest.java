package com.openclassrooms.paymybuddyapi.ControllerTest;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class HistoriqueTransactionControllerTest {

    @Autowired
    private MockMvc mockMvc ;

    @Test
    @Order(1)
    public void testCreateHistorique() throws Exception{
        mockMvc.perform(post("/historique")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"utilisateurId\": \"2\", \"utilisateurIdFriends\":\"1\", \"description\":\"Junit Test\", \"amount\":\"25\"}")
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

    @Test
    @Order(2)
    public void testGetHistoriqueId() throws Exception{
        mockMvc.perform(get("/historique/myHistorique")
                .param("utilisateur_id","2")
        ).andExpect(status().isOk());
    }

    @Test
    @Order(3)
    public void testGetHistoriqueById() throws Exception{
        mockMvc.perform(get("/historiques")
                .param("ids","1")
        ).andExpect(status().isOk());

    }

}
