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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ReseauControllerTest {

    @Autowired
    private MockMvc mockMvc ;

    @Test
    @Order(1)
    public void testAddFriend() throws Exception{
        mockMvc.perform(post("/reseau")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"userAId\": \"1\", \"userBId\":\"2\"}")
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

    @Test
    @Order(2)
    public void testNbrAmi() throws Exception{
        mockMvc.perform(get("/reseau/nbrFriends")
                .param("userId","2")
        ).andExpect(status().isOk());
    }

    @Test
    @Order(3)
    public void testIsFriend() throws Exception{
        mockMvc.perform(get("/reseau/isFriends")
                .param("userAId","1")
                .param("userBId","2")
        ).andExpect(status().isOk());
    }

    @Test
    @Order(4)
    public void testListFriendsFirstName() throws Exception{
        mockMvc.perform(get("/reseau/listFriendsFirstName")
                .param("utilisateur_id","2")
        ).andExpect(status().isOk());

    }

}
