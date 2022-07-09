package com.example.jsonexercise.service.impl;

import com.example.jsonexercise.constants.GlobalConstants;
import com.example.jsonexercise.model.dto.UserSeedDto;
import com.example.jsonexercise.model.dto.UserSoldDto;
import com.example.jsonexercise.model.entity.User;
import com.example.jsonexercise.repository.UserRepository;
import com.example.jsonexercise.service.UserService;
import com.example.jsonexercise.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import static com.example.jsonexercise.constants.GlobalConstants.*;

@Service
public class UserServiceImpl implements UserService {

    private static final String USERS_FILE_NAME = "users.json";

    private final UserRepository userRepository;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final Gson gson;

    public UserServiceImpl(UserRepository userRepository,
                           ValidationUtil validationUtil,
                           ModelMapper modelMapper,
                           Gson gson) {
        this.userRepository = userRepository;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.gson = gson;
    }

    @Override
    public void seedUsers() throws IOException {
        if (userRepository.count() > 0) {
            return;
        }

        Arrays.stream(gson.fromJson(Files.readString(Path.of(RESOURCE_FILES_PATH + USERS_FILE_NAME)),
                 UserSeedDto[].class))
                .filter(validationUtil::isValid)
                .map(userSeedDto -> modelMapper.map(userSeedDto, User.class))
                .forEach(userRepository::save);

    }

    @Override
    public User findRandomUser() {
        long randomId = ThreadLocalRandom
                .current().nextLong(1, userRepository.count() + 1);

        return userRepository
                .findById(randomId)
                .orElse(null);
    }

    @Override
    public List<UserSoldDto> findAllUsersWithMoreThanOneSoldProducts() {
        return userRepository.findAllUsersWithMoreThanOneSoldProductOrderByLastNameThenFirstName()
                .stream()
                .map(user -> modelMapper.map(user, UserSoldDto.class))
                .collect(Collectors.toList());
    }
}
