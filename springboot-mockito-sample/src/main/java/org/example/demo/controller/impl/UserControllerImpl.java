package org.example.demo.controller.impl;

import org.example.demo.controller.UserController;
import org.example.demo.dto.UserDTO;
import org.example.demo.service.port.UserServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller is decoupled from service and domain using service port
 */

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
        return ResponseEntity.ok(userService.getAll());
    }

    @Override
    public ResponseEntity<UserDTO> getUserById(Long id) throws Exception {
        return ResponseEntity.ok(userService.getUser(id));
    }
}
