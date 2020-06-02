package org.example.demo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.demo.controller.impl.UserControllerImpl;
import org.example.demo.dto.UserDTO;
import org.example.demo.service.port.UserServicePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

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

    @Test
    void shouldFindAll() throws Exception{

        when(userService.getAll()).thenReturn(userList);

        this.mockMvc
                .perform(get("/api/1.0.0/users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", is(userList.size())))
                .andExpect(jsonPath("$[0].id", is(1)));
    }
}
