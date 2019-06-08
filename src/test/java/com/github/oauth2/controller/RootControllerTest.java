package com.github.oauth2.controller;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrlPattern;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class RootControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldRedirectToLogin() throws Exception {

        mockMvc.perform(get("/"))
                .andExpect(status().isFound())
                .andExpect(redirectedUrlPattern("http://*/login"));
    }

    @Test
    public void shouldContainAllOAuth2Clients() throws Exception {

        ResultActions resultActions = mockMvc.perform(get("/login"))
                .andExpect(status().isOk());


        String content = resultActions.andReturn()
                .getResponse().getContentAsString();

        assertThat(content, containsString("/oauth2/authorization/github"));
        assertThat(content, containsString("/oauth2/authorization/github-email"));
        assertThat(content, containsString("/oauth2/authorization/google"));
    }
}
