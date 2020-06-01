package org.example.demo.service;

import org.example.demo.domain.User;
import org.example.demo.repository.UserRepository;
import org.example.demo.repository.port.UserRepositoryPort;
import org.example.demo.repository.port.impl.UserRepositoryPortImpl;
import org.example.demo.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepositoryPortImpl userRepository;

    @InjectMocks
    private UserServiceImpl userService;


    @Test
    void shouldSaveUserSuccessfully() throws Exception{

        User user = new User().of("Name").withPassword("password").withEmail("email@email.com");
        when(userRepository.add(any(User.class))).thenReturn(user);
//        given(userRepository.save(user)).willAnswer(invocation -> invocation.getArgument(0));
        User savedUser = userService.createUser(user);

        verify(userRepository).add(any(User.class));


    }
}
