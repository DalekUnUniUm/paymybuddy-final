package com.openclassrooms.paymybuddyapi.ControllerTest;

import com.openclassrooms.paymybuddyapi.PaymybuddyapiApplication;
import com.openclassrooms.paymybuddyapi.controller.ContactController;
import com.openclassrooms.paymybuddyapi.model.Contact;
import com.openclassrooms.paymybuddyapi.service.ContactService;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ContactControllerTest {

    @Autowired
    private MockMvc mockMvc ;

    @Test
    public void testCreateContact() throws Exception {

        mockMvc.perform(post("/contact")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"firstName\": \"Testing\", \"email\":\"test@test.com\", \"problem\":\"I am a problem\"}")
                .accept(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
    }

}
