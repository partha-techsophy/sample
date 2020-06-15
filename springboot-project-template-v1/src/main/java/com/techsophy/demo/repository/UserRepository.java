package com.techsophy.demo.repository;

import com.techsophy.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * JPA repository
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Find user by email
     * @param email
     * @return
     */
    Optional<User> findByEmail(String email);
}
