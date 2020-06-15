package com.techsophy.demo.controller;

import com.techsophy.demo.dto.UserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Rest end point
 * standard format is /{project-name}/{version}/{resource}
 */
@RequestMapping("/api/1.0.0/users")
public interface UserController {

    /**
     * Add user
     * @param userDTO
     * @return
     * @throws Exception
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<UserDTO> createUser(@RequestBody @Validated UserDTO userDTO) throws Exception;

    /**
     * List users
     * @return
     * @throws Exception
     */
    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() throws Exception;

    /**
     * Get user by ID
     * @param id
     * @return
     * @throws Exception
     */
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) throws Exception;
}
