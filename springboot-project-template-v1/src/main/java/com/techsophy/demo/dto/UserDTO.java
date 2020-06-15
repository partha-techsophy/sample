package com.techsophy.demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Data transfer object
 */

/**
 * Lombok is used for Annotation based getter/setter. Configure this in your favourite IDE.
 * For IntelliJ - Go to plugin and searech for Lombok, install and follow the instruction
 * For eclipes - Refer the following link https://projectlombok.org/setup/eclipse
 *
 */
@Data
@NoArgsConstructor
public class UserDTO {
    private long id;

    /**
     * Auto validate email using @Validated in controller
     */
    @Email(message = "Invalid email")
    private String email;

    /**
     * Empty or null password check using @Validated in controller
     * Pattern also can be used to validate
     * @Pattern(regexp = "", "Password must have atleast one capital later and one special character ")
     */
    @NotEmpty(message = "Invalid password")
    @Size(min = 6, max = 16, message = "Password must be minimum 6 character and maximum 16 character")
    private String password;

    /**
     * Validate name with min/max size
     */
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


        /**
         * Create an instance of default user
         * @return
         */
        public Builder withDefaults() {
            this.name = "Default Name";
            this.email = "default@email.com";
            this.password = "password";
            return this;
        }

        /**
         * User with ID
         * @param id
         * @return
         */
        public Builder id(long id) {
            this.id = id;
            return this;
        }

        /**
         * User with name
         * @param name
         * @return
         */
        public Builder name(String name) {
            this.name = name;
            return this;
        }

        /**
         * User with email
         * @param email
         * @return
         */
        public Builder email(String email) {
            this.email = email;
            return this;
        }

        /**
         * User with password
         * @param password
         * @return
         */
        public Builder password(String password) {
            this.password = password;
            return this;
        }

        /**
         * Return UserDTO object
         * @return
         */
        public UserDTO build() {
            return new UserDTO(id, email, password, name);
        }
    }
}
