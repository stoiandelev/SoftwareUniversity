package com.example.battle_ship.service;

import com.example.battle_ship.model.service.UserServiceModel;

public interface UserService {

    boolean register(UserServiceModel userServiceModel);

    UserServiceModel findByUserNameAndPassword(String username, String password);
}
