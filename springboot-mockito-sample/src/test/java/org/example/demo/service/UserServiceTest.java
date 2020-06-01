package org.example.demo.service;

import org.example.demo.domain.User;
import org.example.demo.repository.UserRepository;
import org.example.demo.repository.port.UserRepositoryPort;
import org.example.demo.repository.port.impl.UserRepositoryPortImpl;
import org.example.demo.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.Assert;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepositoryPortImpl userRepository;

    @InjectMocks
    private UserServiceImpl userService;


    @Test
    void shouldSaveUserSuccessfully() throws Exception{

        //Create sample User object and set all the properties
        User user = new User();
        when(userRepository.add(any(User.class))).thenReturn(user);

        //Create sample User object and set all the properties
        User savedUser = userService.createUser(user);

        //You have two ways to test, you can either verify that save method was invoked by
        //verify method
        verify(userRepository, times(1)).add(any(User.class));

        //or by assertion statements, match the authToken in the returned object to be equal
        //to the one set by you in the mocked object
        Assertions.assertEquals(savedUser.getName(), user.getEmail());
    }
}
