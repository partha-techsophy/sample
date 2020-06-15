package com.techsophy.demo.service.impl;

import com.techsophy.demo.domain.User;
import com.techsophy.demo.repository.UserRepository;
import com.techsophy.demo.repository.port.UserRepositoryPort;
import com.techsophy.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * This is the implementation of UserService interface
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepositoryPort userRepository;

    @Autowired
    public UserServiceImpl(UserRepositoryPort userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) throws  Exception{
        user = userRepository.add(user);

        return user;

    }

    @Override
    public void updateEmail(Long id, String email) throws  Exception{

        User user = userRepository.findById(id);
        user.changeEmail(email);
        userRepository.update(user);
    }

    @Override
    public void updatePassword(Long id, String password) throws  Exception{

        User user = userRepository.findById(id);
        user.changePassword(password);
        userRepository.update(user);
    }

    @Override
    public boolean validateLogin(String email, String password) throws  Exception {

        User user = userRepository.findByEmail(email);
        return user.validatePassword(password);
    }

    @Override
    public User getUser(Long id) throws Exception {

        return userRepository.findById(id);
    }

    @Override
    public List<User> getAll() throws Exception {
        return  userRepository.all();
    }

    @Override
    public List<User> getAll(int start, int rows) throws Exception {
        return null;
    }

    private User getUserDTO(User user) {
        return  null;
    }

}
