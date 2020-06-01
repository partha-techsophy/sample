package org.example.demo.service;

import org.example.demo.domain.User;

import java.util.Collection;
import java.util.List;

/**
 * This is the user service interface that defines all the business logic for user domain
 */
public interface UserService {

    public User createUser(User user) throws Exception;
    public void updateEmail(Long id, String email) throws Exception;
    public void updatePassword(Long id, String password) throws Exception;
    public boolean validateLogin(String email, String password) throws Exception;
    public User getUser(Long id) throws  Exception;
    public List<User> getAll() throws  Exception;
    public List<User> getAll(int start, int rows) throws  Exception;
}
