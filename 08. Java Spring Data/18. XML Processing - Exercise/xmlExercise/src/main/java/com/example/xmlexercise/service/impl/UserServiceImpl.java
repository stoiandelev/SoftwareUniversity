package com.example.xmlexercise.service.impl;

import com.example.xmlexercise.model.dto.taskTwoDto.SoldProductRootDto;
import com.example.xmlexercise.model.dto.taskTwoDto.UserWithProductDto;
import com.example.xmlexercise.model.dto.usersSeeds.UserSeedDto;
import com.example.xmlexercise.model.entity.User;
import com.example.xmlexercise.repository.UserRepository;
import com.example.xmlexercise.service.UserService;
import com.example.xmlexercise.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public UserServiceImpl(UserRepository userRepository,
                           ModelMapper modelMapper,
                           ValidationUtil validationUtil) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public void seedUsers(List<UserSeedDto> user) {
        user
                .stream()
                .filter(validationUtil::isValid)
                .map(userSeedDto -> modelMapper.map(userSeedDto, User.class))
                .forEach(userRepository::save);
    }

    @Override
    public User getRandomUser() {
        long randomId = ThreadLocalRandom.current()
                .nextLong(1, userRepository.count() + 1);
        return userRepository
                .findById(randomId)
                .orElse(null);
    }

    @Override
    public SoldProductRootDto findUserWithMoreThanOneProduct() {
        SoldProductRootDto soldProductRootDto = new SoldProductRootDto();
        soldProductRootDto
                .setProducts(userRepository.findAllUsersWithMoreThanOneSoldProduct()
                        .stream()
                        .map(user -> modelMapper.map(user, UserWithProductDto.class))
                        .collect(Collectors.toList()));

        return soldProductRootDto;
    }


    @Override
    public long getEntityCount() {
        return userRepository.count();
    }
}
