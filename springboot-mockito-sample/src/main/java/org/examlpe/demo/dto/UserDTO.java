package org.examlpe.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDTO {
    private long id;
    private String email;
    private String password;
    private String name;

    public UserDTO(long id, String email, String password, String name) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
    }

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
