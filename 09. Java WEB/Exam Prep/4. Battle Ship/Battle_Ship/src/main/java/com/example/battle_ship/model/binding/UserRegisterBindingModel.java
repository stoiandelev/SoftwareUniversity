package com.example.battle_ship.model.binding;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserRegisterBindingModel {

    @NotNull
    @Size(min = 3, max = 10, message = "Username must be between 3 and 10 character!")
    private String username;

    @NotNull
    @Size(min = 5, max = 20, message = "Username must be between 3 and 10 character!")
    private String fullName;

    @NotNull
    @Email(message = "Enter valid email address")
    private String email;

    @NotNull
    @Size(min = 3, message = "Password must be at least 3 character!")
    private String password;

    @NotNull
    @Size(min = 3, message = "Confirmed Password must be at least 3 character!")
    private String confirmPassword;

    public UserRegisterBindingModel() {
    }

    public String getUsername() {
        return username;
    }

    public UserRegisterBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public UserRegisterBindingModel setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserRegisterBindingModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegisterBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegisterBindingModel setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }
}
