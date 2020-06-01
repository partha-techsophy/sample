package org.example.demo.controler;

import org.example.demo.dto.UserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/1.0.0/users")
public interface UserController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<UserDTO> createUser(@RequestBody @Validated UserDTO userDTO) throws Exception;

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() throws Exception;

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) throws Exception;
}
