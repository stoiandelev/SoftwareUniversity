package com.example.softunigamestore_dto.service;

import com.example.softunigamestore_dto.model.dto.UserLoginDto;
import com.example.softunigamestore_dto.model.dto.UserRegisterDto;

public interface UserService {
    void registerUser(UserRegisterDto userRegisterDto);

    void loginUser(UserLoginDto userLoginDto);

    void logout();
}
