package com.openclassrooms.paymybuddyapi.ControllerTest;

import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UtilisateurControllerTest {

    @Autowired
    private MockMvc mockMvc ;

    @Test
    @Order(1)
    public void testCreateUser() throws Exception{
        mockMvc.perform(post("/utilisateur/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"mail\": \"test@test.com\", \"password\":\"1234\", \"lastName\":\"Testing\", \"firstName\":\"Test\"}")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    @Order(2)
    public void testLoginUser() throws Exception{
        mockMvc.perform(get("/utilisateur/login")
                .param("mail","test@test.com")
                .param("password","1234"))
                .andExpect(status().isOk());

    }

    @Test
    public void testFindIdByMail() throws Exception{
        mockMvc.perform(get("/utilisateur")
                .param("mail","test@test.com"))
                .andExpect(status().isOk());

    }

    @Test
    public void testGetUtilisateurs(){

    }

    @Test
    public void testGetUtilisateur(){

    }

    @Test
    public void testUtilisateurIdByName() throws Exception{
         mockMvc.perform(get("/utilisateurIdByName")
                .param("firstName","Test"))
                .andExpect(status().isOk());

    }

    @Test
    public void testSoldesIdByUserId() throws Exception{
        mockMvc.perform(get("/utilisateur/soldesIdById")
                .param("utilisateurId","2"))
                .andExpect(status().isOk());

    }

    @Test
    public void testFirstNameByUserId() throws Exception{
        mockMvc.perform(get("/utilisateur/firstNameById")
                .param("utilisateurId","2"))
                .andExpect(status().isOk());

    }


}
