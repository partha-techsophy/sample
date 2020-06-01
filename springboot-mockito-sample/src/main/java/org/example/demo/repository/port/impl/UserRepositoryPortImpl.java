package org.example.demo.repository.port.impl;

import org.example.demo.domain.User;
import org.example.demo.repository.UserRepository;
import org.example.demo.repository.port.UserRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserRepositoryPortImpl implements UserRepositoryPort {

    private UserRepository userRepository;

    @Autowired
    public UserRepositoryPortImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User add(User user) throws Exception {
        return userRepository.save(user);
    }

    @Override
    public User update(User user) throws Exception {
        return userRepository.save(user);
    }

    @Override
    public void delete(User user) throws Exception {
        userRepository.delete(user);
    }

    @Override
    public List<User> all() throws Exception {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) throws Exception {
        Optional<User> userOptional = userRepository.findById(id);
        if(userOptional.isPresent()) {
            return userOptional.get();
        } else {
            throw new Exception("User with this id not found");
        }

    }

    @Override
    public User findByEmail(String email) throws Exception {
        Optional<User> userOptional = userRepository.findByEmail(email);
        if(userOptional.isPresent()) {
            return userOptional.get();
        } else {
            throw new Exception("User with this email not found");
        }
    }
}
