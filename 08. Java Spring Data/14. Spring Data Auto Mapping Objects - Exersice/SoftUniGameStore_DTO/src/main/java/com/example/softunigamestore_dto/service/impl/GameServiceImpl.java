package com.example.softunigamestore_dto.service.impl;

import com.example.softunigamestore_dto.model.dto.GameAddDto;
import com.example.softunigamestore_dto.model.entity.Game;
import com.example.softunigamestore_dto.repository.GameRepository;
import com.example.softunigamestore_dto.service.GameService;
import com.example.softunigamestore_dto.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public GameServiceImpl(GameRepository gameRepository,
                           ModelMapper modelMapper,
                           ValidationUtil validationUtil) {
        this.gameRepository = gameRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;

    }

    @Override
    public void addGame(GameAddDto gameAddDto) {

        Set<ConstraintViolation<GameAddDto>> violations = validationUtil.getViolations(gameAddDto);
        if (!violations.isEmpty()) {
            violations
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);
            return;
        }
        Game game = modelMapper.map(gameAddDto, Game.class);
        gameRepository.save(game);
        System.out.printf("Added %s%n", gameAddDto.getTitle());

    }

    @Override
    public void editGame(Long gameId, BigDecimal price, Double size) {
        Game game = gameRepository.findById(gameId).orElse(null);

        if (game == null) {
            System.out.println("Id is not exists");
            return;
        }

        game.setPrice(price);
        game.setSize(size);

        gameRepository.save(game);
        System.out.printf("Edited %s%n", game.getTitle());
    }

    @Override
    public void deleteGame(Long gameId) {
        Game game = gameRepository.findById(gameId).orElse(null);

        if (game == null) {
            System.out.println("Id is not exists");
            return;
        }

        gameRepository.delete(game);
        System.out.printf("Deleted %s%n", game.getTitle());
    }

    @Override
    public List<String> printAllGamesAndPrice() {
        return gameRepository
                .findAllByTitleAndPrice()
                .stream()
                .map(game -> String.format("%s %.2f", game.getTitle(), game.getPrice()))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getDetailsGame(String nameOfGame) {

        return gameRepository.findAllByTitle(nameOfGame)
                .stream()
                .map(game ->
                    String.format("Title: %s%n Price: %.2f%n Description: %s%n Release date:  %s%n",
                            game.getTitle(),
                            game.getPrice(),
                            game.getDescription(),
                            game.getReleaseDate())
                )
                .collect(Collectors.toList());
    }




}
