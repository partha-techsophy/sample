package org.example.demo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.demo.controller.impl.UserControllerImpl;
import org.example.demo.dto.UserDTO;
import org.example.demo.service.port.UserServicePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentCaptor.forClass;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.hamcrest.CoreMatchers.is;


@WebMvcTest(controllers = UserController.class)
@ActiveProfiles("Test")
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserServicePort userService;

    @Autowired
    private ObjectMapper objectMapper;

    private List<UserDTO> userList;

    @BeforeEach
    void setUp() {
        this.userList = new ArrayList<>();
        this.userList.add(new UserDTO.Builder().withDefaults().id(1).build());
        this.userList.add(new UserDTO.Builder().withDefaults().id(2).build());
        this.userList.add(new UserDTO.Builder().withDefaults().id(3).build());

    }

    /**
     * 1. Mock the results of our service calls
     * 2. We define our expectations and our API call using MockMvc
     * 3. The next step is to use MockMvc to make our API call and write our expectations:
     *
     * @throws Exception
     */
    @Test
    void shouldFindAll() throws Exception{

        when(userService.getAll()).thenReturn(userList);

        this.mockMvc
                .perform(get("/api/1.0.0/users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", is(userList.size())))
                .andExpect(jsonPath("$[0].id", is(1)));
    }

    @Test
    void shouldAddUser() throws  Exception{

//        Mock the user
        UserDTO user = new UserDTO.Builder().withDefaults().id(1).build();
        when(userService.createUser(user)).thenReturn(user);

        this.mockMvc
                .perform(post("/api/1.0.0/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email", is(user.getEmail())));

//        The final step is to capture the arguments passed to the service.create(..)
//        method by using Mockito’s ArgumentCaptor API:
//        Using the ArgumentCaptor we can verify if the JSON request matches the user input

        ArgumentCaptor<UserDTO> anyUser = forClass(UserDTO.class);
        verify(userService).createUser(anyUser.capture());
        assertThat(anyUser.getValue().getEmail()).isEqualTo("default@email.com");
    }
}
