package org.examlpe.demo.service;

import org.examlpe.demo.domain.User;
import org.examlpe.demo.dto.UserDTO;

import java.util.Collection;

public interface UserService {

    public User createUser(User user) throws Exception;
    public void updateEmail(Long id, String email) throws Exception;
    public void updatePassword(Long id, String password) throws Exception;
    public boolean validateLogin(String email, String password) throws Exception;
    public User getUser(Long id) throws  Exception;
    public Collection<User> getAll() throws  Exception;
    public Collection<User> getAll(int start, int rows) throws  Exception;
}
