package com.example.softunigamestore_dto.service;

import com.example.softunigamestore_dto.model.dto.GameAddDto;

import java.math.BigDecimal;
import java.util.List;


public interface GameService {
    void addGame(GameAddDto gameAddDto);

    void editGame(Long gameId, BigDecimal price, Double size);

    void deleteGame(Long gameId);

    List<String> printAllGamesAndPrice();

    List<String> getDetailsGame(String nameOfGame);
}
