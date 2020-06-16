package com.techsophy.demo.dto.assembler;

import com.techsophy.demo.domain.User;
import com.techsophy.demo.dto.UserDTO;

/**
 * Data transfer object converter
 */
public final class UserAssembler {

    private UserAssembler() {

    }
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
