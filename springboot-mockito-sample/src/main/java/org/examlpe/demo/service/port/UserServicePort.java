package org.examlpe.demo.service.port;

import org.examlpe.demo.dto.UserDTO;
import org.examlpe.demo.dto.assembler.UserAssembler;
import org.examlpe.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
