package com.techsophy.demo.repository.port.impl;

import com.techsophy.demo.domain.User;
import com.techsophy.demo.exception.UserNotFoundException;
import com.techsophy.demo.repository.UserRepository;
import com.techsophy.demo.repository.port.UserRepositoryPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

/**
 * JPA User repository port implementation
 */
@Service
public class UserRepositoryPortImpl implements UserRepositoryPort {

    private final UserRepository userRepository;

    private final MessageSource messageSource;

    Logger logger = LoggerFactory.getLogger(UserRepositoryPortImpl.class);

    @Autowired
    public UserRepositoryPortImpl(UserRepository userRepository,
                                  MessageSource messageSource) {
        this.userRepository = userRepository;
        this.messageSource = messageSource;
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
            String message = messageSource.getMessage("user.notfound", null, Locale.getDefault());
            String formattedMessage = MessageFormat.format(message, id);
            logger.warn(formattedMessage);
            throw new UserNotFoundException(formattedMessage);
        }

    }

    @Override
    public User findByEmail(String email) throws Exception {
        Optional<User> userOptional = userRepository.findByEmail(email);
        if(userOptional.isPresent()) {
            return userOptional.get();
        } else {
            throw new UserNotFoundException("User with this email not found");
        }
    }
}
