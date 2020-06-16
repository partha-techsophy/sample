package com.techsophy.demo.domain;

import com.techsophy.demo.exception.InvalidEmailException;
import com.techsophy.demo.exception.InvalidInputException;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

/**
 * Root Aggregate for User domain. This should own the user domain. Any data should not be
 * leaked from this domain using getter and setter
 * Never allow developer to construct domain object directly. Encapsulate everyting and allow only
 * behavior that can be managed
 * TODO - Remove default getter/setter and add only specified getter/setter
 */

@Entity
@Table(name = "users")
@NoArgsConstructor
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Email should not be empty")
    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(nullable = false, length = 100)
    private String password;

    @Column(nullable = false, length = 100)
    private String name;


    /**
     * Never allow developer to construct domain object directly.
     * Encapsulate everything and allow only behavior that can be managed
     *
     * @param name
     * @return
     * @throws Exception
     */
    public User of(String name) throws Exception {
        if(name == null || name.isEmpty()) {
            throw new InvalidInputException("Invalid name");
        }
        this.setName(name);
        return this;
    }

    public User withEmail(String email) throws Exception {
        if(email == null || email.isEmpty()) {
            throw new InvalidEmailException("Invalid email");
        }
        this.setEmail(email);
        return this;
    }

    public User withPassword(String password) throws Exception {
        if(password == null || password.isEmpty()) {
            throw new InvalidInputException("Invalid password");
        }
        this.password = password;
        return this;
    }

    public void changeEmail(String email) throws Exception{
        if(email == null || email.isEmpty()) {
            throw new InvalidInputException("Invalid email");
        }
        this.email = email;
    }

    public void changePassword(String password) throws Exception{
        if(password == null || password.isEmpty()) {
            throw new InvalidInputException("Invalid password");
        }
        this.password = password;
    }

    public void changeName(String name) throws Exception{
        if(name == null || name.isEmpty()) {
            throw new InvalidInputException("Invalid name");
        }
        this.name = name;
    }

    public boolean validatePassword(String password) throws Exception{

        if(!this.password.equals(password)) {
            throw new InvalidInputException("Invalid password");
        }

        return true;
    }
}
