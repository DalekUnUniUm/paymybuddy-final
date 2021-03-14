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
public class PorteMonnaieControllerTest {

    @Autowired
    private MockMvc mockMvc ;

    @Test
    @Order(1)
    public void testCreatePorteMonnaie() throws Exception{

        mockMvc.perform(post("/wallet")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"soldes\": \"0\", \"bankAccount\":\"0\", \"available\":\"true\"}")
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

    }

    @Test
    @Order(4)
    public void testUpdateBankAccount() throws Exception{

        mockMvc.perform(put("/wallet/bankaccount")
                .param("bankaccount","12345678945")
                .param("soldesId","2")
        ).andExpect(status().isOk());

    }

    @Test
    public void testGetBankAccount() throws Exception{
        mockMvc.perform(get("/wallet/getBankAccount")
                .param("soldesId","2")
        ).andExpect(status().isOk());

    }

    @Test
    public void testGetSoldes() throws Exception{
        mockMvc.perform(get("/wallet/soldes")
                .param("soldesId","2")
        ).andExpect(status().isOk());
    }

    @Test
    public void testUpdateSoldesAdd() throws Exception{
        mockMvc.perform(put("/wallet/updateSoldesAdd")
                .param("addSoldes","50")
                .param("soldesId","2")
        ).andExpect(status().isOk());
    }

    @Test
    public void testUpdateSoldesSoustract() throws Exception{
        mockMvc.perform(put("/wallet/updateSoldesSoustract")
                .param("soustractSoldes","50")
                .param("soldesId","2")
        ).andExpect(status().isOk());
    }

}
