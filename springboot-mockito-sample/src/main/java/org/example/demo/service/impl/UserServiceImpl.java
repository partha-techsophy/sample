package org.example.demo.service.impl;

import org.example.demo.domain.User;
import org.example.demo.repository.UserRepository;
import org.example.demo.repository.port.UserRepositoryPort;
import org.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Optional;

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
    public Collection<User> getAll() throws Exception {
        return  userRepository.all();
    }

    @Override
    public Collection<User> getAll(int start, int rows) throws Exception {
        return null;
    }

    private User getUserDTO(User user) {
        return  null;
    }

}
