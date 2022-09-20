package com.example.spotifyplaylistapp.model.binding;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserRegisterDTO {

    @Size(min = 3, max = 20, message = "Username must be between 3 and 20 character!")
    @NotNull
    private String username;

    @NotBlank(message = "Email cannot be empty!")
    @Email(message = "Please enter valid email!")
    private String email;

    @Size(min = 3, max = 20, message = "Password must be between 3 and 20 character!")
    @NotNull
    private String password;

    @Size(min = 3, max = 20, message = "Confirmed Password must be between 3 and 20 character!")
    @NotNull
    private String confirmPassword;

    public UserRegisterDTO() {
    }

    public String getUsername() {
        return username;
    }

    public UserRegisterDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserRegisterDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegisterDTO setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegisterDTO setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }
}
