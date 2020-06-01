package org.example.demo.dto.assembler;

import org.example.demo.domain.User;
import org.example.demo.dto.UserDTO;

public class UserAssembler {

    public static UserDTO writeToDto(User user) {
        return new UserDTO.Builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }

    public static User writeToUser(UserDTO userDTO) throws Exception{

        return new User().of(userDTO.getName())
                .withEmail(userDTO.getEmail())
                .withPassword(userDTO.getPassword());
    }
}
