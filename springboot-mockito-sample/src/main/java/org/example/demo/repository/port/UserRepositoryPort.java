package org.example.demo.repository.port;

import org.example.demo.domain.User;

import java.util.List;

/**
 * This UserRepositoryPort to decouple code from DB infrastructure changes
 */
public interface UserRepositoryPort {

    public User add(User user) throws Exception;
    public User update(User user) throws Exception;
    public void delete(User user) throws Exception;
    public List<User> all() throws Exception;
    public User findById(Long id) throws Exception;
    public User findByEmail(String email) throws Exception;


}
