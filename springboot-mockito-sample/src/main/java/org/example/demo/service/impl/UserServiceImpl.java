package org.example.demo.service.impl;

import org.example.demo.domain.User;
import org.example.demo.repository.UserRepository;
import org.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) throws  Exception{
        user = userRepository.save(user);

        return user;

    }

    @Override
    public void updateEmail(Long id, String email) throws  Exception{
        Optional<User> userOpt = this.userRepository.findById(id);
        if(!userOpt.isPresent()) {
            throw new Exception("Invalid user");
        }
        User user = userOpt.get();
        user.changeEmail(email);
        userRepository.save(user);
    }

    @Override
    public void updatePassword(Long id, String password) throws  Exception{
        Optional<User> userOpt = this.userRepository.findById(id);
        if(!userOpt.isPresent()) {
            throw new Exception("Invalid user");
        }
        User user = userOpt.get();
        user.changePassword(password);
        userRepository.save(user);
    }

    @Override
    public boolean validateLogin(String email, String password) throws  Exception {
        Optional<User> userOpt = this.userRepository.findByEmail(email);
        if(!userOpt.isPresent()) {
            throw new Exception("Invalid user");
        }
        User user = userOpt.get();
        return user.validatePassword(password);
    }

    @Override
    public User getUser(Long id) throws Exception {
        Optional<User> userOpt = this.userRepository.findById(id);
        if(!userOpt.isPresent()) {
            throw new Exception("Invalid user");
        }
        return userOpt.get();
    }

    @Override
    public Collection<User> getAll() throws Exception {
        return  userRepository.findAll();
    }

    @Override
    public Collection<User> getAll(int start, int rows) throws Exception {
        return null;
    }

    private User getUserDTO(User user) {
        return  null;
    }

}