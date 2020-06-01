package org.examlpe.demo.service.impl;

import org.examlpe.demo.domain.User;
import org.examlpe.demo.dto.UserDTO;
import org.examlpe.demo.dto.assembler.UserAssembler;
import org.examlpe.demo.repository.UserRepository;
import org.examlpe.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void createUser(UserDTO userDto) throws  Exception{
        User user = UserAssembler.writeToUser(userDto);
        userRepository.save(user);

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
    public UserDTO getUser(Long id) throws Exception {
        Optional<User> userOpt = this.userRepository.findById(id);
        if(!userOpt.isPresent()) {
            throw new Exception("Invalid user");
        }
        return UserAssembler.writeToDto(userOpt.get());
    }

    @Override
    public Collection<UserDTO> getAll() throws Exception {
        return  userRepository.findAll()
                .stream()
                .map(this::getUserDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<UserDTO> getAll(int start, int rows) throws Exception {
        return null;
    }

    private UserDTO getUserDTO(User user) {
        return  UserAssembler.writeToDto(user);
    }

}
