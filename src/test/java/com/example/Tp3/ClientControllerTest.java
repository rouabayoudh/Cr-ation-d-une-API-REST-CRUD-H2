
        package com.example.Tp3;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
public class ClientControllerTest {

    @Autowired
    private WebApplicationContext applicationContext;

    private MockMvc mvc;

    @MockBean
    private ClientRepository repository;

    @BeforeEach
    public void setUp() {
        mvc = MockMvcBuilders.webAppContextSetup(applicationContext).build();
    }

    @Test
    public void testClientController() throws Exception {
        Client client = new Client();
        client.setNom("Rouee");
        client.setAge(22);

        mvc.perform(post("/client")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(toJson(client)))
                .andExpect(status().isOk());

        mvc.perform(get("/client/1"))
                .andExpect(status().isOk());

        mvc.perform(delete("/client/1"))
                .andExpect(status().isOk());
    }

    private String toJson(Object obj) throws Exception {
        return new ObjectMapper().writeValueAsString(obj);
    }
}