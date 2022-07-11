package com.example.xmlexercise.service;

import com.example.xmlexercise.model.dto.taskTwoDto.SoldProductRootDto;
import com.example.xmlexercise.model.dto.usersSeeds.UserSeedDto;
import com.example.xmlexercise.model.entity.User;

import java.util.List;

public interface UserService {
    long getEntityCount();

    void seedUsers(List<UserSeedDto> user);

    User getRandomUser();

    SoldProductRootDto findUserWithMoreThanOneProduct();
}
