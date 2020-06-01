package org.example.demo.controler.impl;

import org.example.demo.controler.UserController;
import org.example.demo.dto.UserDTO;
import org.example.demo.service.port.UserServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class UserControllerImpl implements UserController {

    private UserServicePort userService;

    @Autowired
    public UserControllerImpl(UserServicePort userService) {
        this.userService = userService;
    }

    @Override
    public ResponseEntity<UserDTO> createUser(UserDTO userDTO) throws Exception {

        return ResponseEntity.ok(userService.createUser(userDTO));
    }

    @Override
    public ResponseEntity<List<UserDTO>> getAllUsers() throws Exception {
        return ResponseEntity.ok(Arrays.asList(new UserDTO.Builder()
                .withDefaults()
                .build()));
    }

    @Override
    public ResponseEntity<UserDTO> getUserById(Long id) throws Exception {
        return ResponseEntity.ok(new UserDTO.Builder()
                .withDefaults()
                .build());
    }
}
