package org.examlpe.demo.service;

import org.examlpe.demo.dto.UserDTO;

import java.util.Collection;

public interface UserService {

    public void createUser(UserDTO userDto) throws Exception;
    public void updateEmail(Long id, String email) throws Exception;
    public void updatePassword(Long id, String password) throws Exception;
    public boolean validateLogin(String email, String password) throws Exception;
    public UserDTO getUser(Long id) throws  Exception;
    public Collection<UserDTO> getAll() throws  Exception;
    public Collection<UserDTO> getAll(int start, int rows) throws  Exception;
}
