package com.techsophy.demo.service.port;

import com.techsophy.demo.domain.User;
import com.techsophy.demo.dto.UserDTO;
import com.techsophy.demo.dto.assembler.UserAssembler;
import com.techsophy.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * UserServicePort decouples the service implementation from controller.
 */
@Service
public class UserServicePort {

    private final UserService userService;

    @Autowired
    public UserServicePort(UserService userService) {
        this.userService = userService;
    }

    public UserDTO createUser(UserDTO userDto) throws  Exception{
        return UserAssembler.writeToDto(
                userService.createUser(UserAssembler.writeToUser(userDto))
        );
    }

    public List<UserDTO> getAll() throws Exception {
        return userService.getAll()
                .stream()
                .map(UserAssembler::writeToDto)
                .collect(Collectors.toList());
    }

    public UserDTO getUser(Long id) throws Exception {
        return  UserAssembler.writeToDto(userService.getUser(id));
    }
}
