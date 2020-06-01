package org.example.demo.domain;

import lombok.*;

import javax.persistence.*;


@Entity
@Table(name = "users")
@NoArgsConstructor
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @NotEmpty(message = "Email should not be empty")
    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(nullable = false, length = 100)
    private String password;

    @Column(nullable = false, length = 100)
    private String name;


    public User of(String name) throws Exception {
        if(name == null || name.isEmpty()) {
            throw new Exception("Invalid name");
        }
        this.setName(name);
        return this;
    }

    public User withEmail(String email) throws Exception {
        if(email == null || email.isEmpty()) {
            throw new Exception("Invalid email");
        }
        this.setEmail(email);
        return this;
    }

    public User withPassword(String password) throws Exception {
        if(password == null || password.isEmpty()) {
            throw new Exception("Invalid password");
        }
        this.password = password;
        return this;
    }

    public void changeEmail(String email) throws Exception{
        if(email == null || email.isEmpty()) {
            throw new Exception("Invalid email");
        }
        this.email = email;
    }

    public void changePassword(String password) throws Exception{
        if(password == null || password.isEmpty()) {
            throw new Exception("Invalid password");
        }
        this.password = password;
    }

    public void changeName(String name) throws Exception{
        if(name == null || name.isEmpty()) {
            throw new Exception("Invalid name");
        }
        this.name = name;
    }

    public boolean validatePassword(String password) throws Exception{

        if(!this.password.equals(password)) {
            throw new Exception("Invalid password");
        }

        return true;
    }
}
