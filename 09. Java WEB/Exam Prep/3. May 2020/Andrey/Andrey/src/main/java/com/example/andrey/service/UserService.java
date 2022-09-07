package com.example.andrey.service;

import com.example.andrey.model.service.UserServiceModel;

public interface UserService {

    UserServiceModel register(UserServiceModel userServiceModel);

    UserServiceModel findByUserName(String username);

    UserServiceModel findByEmail(String email);
}
