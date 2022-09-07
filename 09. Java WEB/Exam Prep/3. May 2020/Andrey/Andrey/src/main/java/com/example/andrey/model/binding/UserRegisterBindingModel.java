package com.example.andrey.model.binding;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class UserRegisterBindingModel {

    @Size(min = 2, message = "Username must be min 2 character!")
    @NotBlank(message = "Username can not be empty String")
    private String username;

    @Size(min = 2, message = "Password must be min 2 character!")
    @NotBlank(message = "Username can not be empty String")
    private String password;

    @Size(min = 2, message = "Password must be min 2 character!")
    @NotBlank
    private String confirmPassword;

    @NotBlank(message = "Please enter valid email!")
    @Email()
    private String email;

    @DecimalMin(value = "0", message = "Budget must be positive number!")
    private BigDecimal budget;

    public UserRegisterBindingModel() {
    }

    public String getUsername() {
        return username;
    }

    public UserRegisterBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegisterBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserRegisterBindingModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public UserRegisterBindingModel setBudget(BigDecimal budget) {
        this.budget = budget;
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
