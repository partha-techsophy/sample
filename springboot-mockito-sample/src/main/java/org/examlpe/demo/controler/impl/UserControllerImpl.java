package org.examlpe.demo.controler.impl;

import org.examlpe.demo.controler.UserController;
import org.examlpe.demo.dto.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RestController
public class UserControllerImpl implements UserController {

    @Override
    public ResponseEntity<UserDTO> createUser(UserDTO userDTO) throws Exception {

        return ResponseEntity.ok(new UserDTO.Builder()
                .withDefaults()
                .build());
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
