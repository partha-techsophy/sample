package com.techsophy.demo.service;

import com.techsophy.demo.domain.User;

import java.util.Collection;
import java.util.List;

/**
 * This is the user service interface that defines all the business logic/ use case for user domain
 */
public interface UserService {


    /**
     * Create user
     * @param user
     * @return
     * @throws Exception
     */
    public User createUser(User user) throws Exception;

    /**
     * Update email
     * @param id
     * @param email
     * @throws Exception
     */
    public void updateEmail(Long id, String email) throws Exception;

    /**
     * Update password
     * @param id
     * @param password
     * @throws Exception
     */
    public void updatePassword(Long id, String password) throws Exception;

    /**
     * Validate login
     * @param email
     * @param password
     * @return
     * @throws Exception
     */
    public boolean validateLogin(String email, String password) throws Exception;

    /**
     * Find user by ID
     * @param id
     * @return
     * @throws Exception
     */
    public User getUser(Long id) throws  Exception;

    /**
     * List all users
     * Extend this function to use pagination
     * @return
     * @throws Exception
     */
    public List<User> getAll() throws  Exception;

    /**
     * List user with pagination
     * Extend this function to use sorting
     * @param start
     * @param rows
     * @return
     * @throws Exception
     */
    public List<User> getAll(int start, int rows) throws  Exception;
}
