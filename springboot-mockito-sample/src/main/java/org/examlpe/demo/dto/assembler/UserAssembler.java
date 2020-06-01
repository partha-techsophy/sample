package org.examlpe.demo.dto.assembler;

import org.examlpe.demo.domain.User;
import org.examlpe.demo.dto.UserDTO;

public class UserAssembler {

    public static UserDTO writeToDto(User user) {
        return new UserDTO.Builder()
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
