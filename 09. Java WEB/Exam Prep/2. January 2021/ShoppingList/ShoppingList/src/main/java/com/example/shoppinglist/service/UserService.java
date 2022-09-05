package com.example.shoppinglist.service;

import com.example.shoppinglist.model.service.UserServiceModel;

public interface UserService {

    boolean register(UserServiceModel userServiceModel);

    UserServiceModel findByUserNameAndPassword(String username, String password);
}
