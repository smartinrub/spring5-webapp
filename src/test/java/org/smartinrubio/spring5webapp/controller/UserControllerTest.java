package org.smartinrubio.spring5webapp.controller;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.smartinrubio.spring5webapp.model.Hotel;
import org.smartinrubio.spring5webapp.model.User;
import org.smartinrubio.spring5webapp.repository.UserRepository;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @InjectMocks
    private UserController controller;

    @Mock
    private UserRepository repository;

    private MockMvc mockMvc;

    @BeforeEach
    public void init() {
        mockMvc = standaloneSetup(controller).build();
    }

    @Test
    public void showRegistrationForm_thenReturnRegistrationPage() throws Exception {

        mockMvc.perform(get("/user/register"))
                .andExpect(view().name("registerForm"));
    }

    @Test
    public void submitRegistrationForm_thenSaveUser() throws Exception {
        User userToSave = new User("Sergio", "Martin", "sergio@gmail.com", "password");

        repository.save(userToSave);

        mockMvc.perform(post("/user/register")
                .param("firstName", "Sergio")
                .param("lastName", "Martin")
                .param("email", "sergio@gmail.com")
                .param("password", "password"))
                .andExpect(redirectedUrl("/user/sergio"));

        verify(repository, atLeastOnce()).save(userToSave);
    }

}