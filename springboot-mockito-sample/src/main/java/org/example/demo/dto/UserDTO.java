package org.example.demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Data transfer object
 */

@Data
@NoArgsConstructor
public class UserDTO {
    private long id;
    @Email(message = "Invalid email")
    private String email;
    @NotEmpty(message = "Invalid password")
    @Size(min = 6, max = 16, message = "Password must be minimum 6 character and maximum 16 character")
//    @Pattern(regexp = "", "Password must have atleast one capital later and one special character ")
    private String password;
    @NotEmpty(message = "Invalid name")
    @Size(min = 3, max = 90, message = "Name must be min 3 characters")
    private String name;

    public UserDTO(long id, String email, String password, String name) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
    }

    /**
     * Builder pattern helps in reducing error in code
     */
    public static class Builder {
        private String email;
        private String password;
        private String name;
        private long id;

        public Builder() {}


        public Builder withDefaults() {
            this.name = "Default Name";
            this.email = "default@email.com";
            this.password = "password";
            return this;
        }

        public Builder id(long id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public UserDTO build() {
            return new UserDTO(id, email, password, name);
        }
    }
}
