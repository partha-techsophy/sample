package org.example.demo.service.port;

import org.example.demo.domain.User;
import org.example.demo.dto.UserDTO;
import org.example.demo.dto.assembler.UserAssembler;
import org.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * UserServicePort decouples the service implementation from controller.
 */
@Service
public class UserServicePort {

    private UserService userService;

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
