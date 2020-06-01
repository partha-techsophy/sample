package com.example.demo.service;

import org.assertj.core.api.BDDAssumptions;
import org.examlpe.demo.domain.User;
import org.examlpe.demo.dto.UserDTO;
import org.examlpe.demo.dto.assembler.UserAssembler;
import org.examlpe.demo.repository.UserRepository;
import org.examlpe.demo.service.UserService;
import org.examlpe.demo.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;


    @Test
    void shouldSaveUserSuccessfully() throws Exception{

        User user = new User().of("Name").withPassword("password").withEmail("email@email.com");
        when(userRepository.save(any(User.class))).thenReturn(user);
//        given(userRepository.save(user)).willAnswer(invocation -> invocation.getArgument(0));
        User savedUser = userService.createUser(user);

        verify(userRepository).save(any(User.class));


    }
}
