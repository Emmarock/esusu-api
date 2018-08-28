package com.emmarock.model;

/**
 * Created by babajide.apata on 2/16/2017.
 */
public class LoginRequest {
    private String username;
    private String email;
    private String password;
    private String passwordResetCode;
    public LoginRequest() {
    }

    private LoginRequest(Builder builder) {
        username = builder.username;
        email = builder.email;
        password = builder.password;
        passwordResetCode = builder.passwordResetCode;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPasswordResetCode() {
        return passwordResetCode;
    }

    public static final class Builder {
        private String username;
        private String email;
        private String password;
        private String passwordResetCode;

        public Builder() {
        }

        public Builder username(String username) {
            this.username = username;
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
        public Builder passwordResetCode(String passwordResetCode){
            this.passwordResetCode = passwordResetCode;
            return this;
        }
        public LoginRequest build() {
            return new LoginRequest(this);
        }
    }
}
