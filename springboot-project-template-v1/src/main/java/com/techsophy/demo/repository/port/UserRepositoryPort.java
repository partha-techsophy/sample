package com.techsophy.demo.repository.port;

import com.techsophy.demo.domain.User;

import java.util.List;

/**
 * This UserRepositoryPort to decouple code from DB infrastructure changes
 */
public interface UserRepositoryPort {

    /**
     * Add user
     * @param user
     * @return
     * @throws Exception
     */
    public User add(User user) throws Exception;

    /**
     * Update user
     * @param user
     * @return
     * @throws Exception
     */
    public User update(User user) throws Exception;

    /**
     * Delete user
     * @param user
     * @throws Exception
     */
    public void delete(User user) throws Exception;

    /**
     * List all users
     * @return
     * @throws Exception
     */
    public List<User> all() throws Exception;

    /**
     * Find by ID
     * @param id
     * @return
     * @throws Exception
     */
    public User findById(Long id) throws Exception;

    /**
     * Find by email
     * @param email
     * @return
     * @throws Exception
     */
    public User findByEmail(String email) throws Exception;


}
