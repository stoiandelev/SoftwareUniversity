package com.example.andrey.model.binding;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserLoginBindingModel {

    @Size(min = 2, message = "Username must be min 2 character!")
    @NotBlank(message = "Username can not be empty String")
    private String username;

    @Size(min = 2, message = "Password must be min 2 character!")
    @NotBlank(message = "Username can not be empty String")
    private String password;

    public UserLoginBindingModel() {
    }

    public String getUsername() {
        return username;
    }

    public UserLoginBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserLoginBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }
}
