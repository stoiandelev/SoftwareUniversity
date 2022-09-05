package com.example.shoppinglist.service.impl;

import com.example.shoppinglist.model.service.UserServiceModel;
import com.example.shoppinglist.model.entity.UserEntity;
import com.example.shoppinglist.repository.UserRepository;
import com.example.shoppinglist.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean register(UserServiceModel userServiceModel) {

        try {
            userRepository
                    .save(modelMapper.map(userServiceModel, UserEntity.class));
        } catch (Exception e) {
            return false;
        }


        return true;
    }

    @Override
    public UserServiceModel findByUserNameAndPassword(String username, String password) {
        return userRepository
                .findByUsernameAndPassword(username, password)
                .map(userEntity -> modelMapper.map(userEntity, UserServiceModel.class))
                .orElse(null);
    }
}
