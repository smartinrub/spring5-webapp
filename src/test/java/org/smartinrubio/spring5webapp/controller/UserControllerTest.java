package org.smartinrubio.spring5webapp.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.smartinrubio.spring5webapp.model.User;
import org.smartinrubio.spring5webapp.repository.UserRepository;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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
    public void userForm_thenReturnRegistrationPage() throws Exception {

        mockMvc.perform(get("/user/register"))
                .andExpect(view().name("registerForm"));
    }

    @Test
    public void userSubmit_thenSaveUser() throws Exception {
        User userToSave = new User("Sergio", "Martin", "sergio@gmail.com", "password");

        when(repository.save(any(User.class))).thenReturn(userToSave);

        repository.save(userToSave);

        MockMultipartFile firstFile = new MockMultipartFile(
                "profilePicture",
                "profilePicture.png",
                "image/png",
                "profilePicture".getBytes());


        mockMvc.perform(
                MockMvcRequestBuilders.multipart("/user/register")
                        .file(firstFile)
                        .param("some-random", "4")
                        .param("firstName", userToSave.getFirstName())
                        .param("lastName", userToSave.getLastName())
                        .param("email", userToSave.getEmail())
                        .param("password", userToSave.getPassword()))
                .andExpect(redirectedUrl("/user/sergio"));

        verify(repository, atLeastOnce()).save(userToSave);
    }

}