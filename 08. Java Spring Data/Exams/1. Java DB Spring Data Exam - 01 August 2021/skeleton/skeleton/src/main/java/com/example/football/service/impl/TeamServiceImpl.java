package com.example.football.service.impl;

import com.example.football.models.dto.TeamSeedDto;
import com.example.football.models.entity.Team;
import com.example.football.models.entity.Town;
import com.example.football.repository.TeamRepository;
import com.example.football.service.TeamService;
import com.example.football.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
public class TeamServiceImpl implements TeamService {

    private static final String TEAMS_FILE_PATH = "/Users/stoiandelev/Desktop/skeleton/skeleton/src/main/resources/files/json/teams.json";

    private final TeamRepository teamRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    private final TownServiceImpl townServiceImpl;

    public TeamServiceImpl(TeamRepository teamRepository,
                           Gson gson,
                           ModelMapper modelMapper,
                           ValidationUtil validationUtil,
                           TownServiceImpl townServiceImpl) {
        this.teamRepository = teamRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.townServiceImpl = townServiceImpl;
    }

    @Override
    public boolean areImported() {
        return teamRepository.count() > 0;
    }

    @Override
    public String readTeamsFileContent() throws IOException {
        return Files
                .readString(Path.of(TEAMS_FILE_PATH));
    }

    @Override
    public String importTeams() throws IOException {
        StringBuilder sb = new StringBuilder();

//        TeamSeedDto[] teamSeedDtos = gson
//                .fromJson(readTeamsFileContent(), TeamSeedDto[].class);

        Arrays.stream(gson
                        .fromJson(readTeamsFileContent(), TeamSeedDto[].class))
                .filter(teamSeedDto -> {
                    boolean isValid = validationUtil.isValid(teamSeedDto)
                            && !teamNameIsNotInDB(teamSeedDto.getName());
                    sb
                            .append(isValid
                                    ? String.format("Successfully imported Team %s - %d",
                                    teamSeedDto.getName(),
                                    teamSeedDto.getFanBase())
                                    : "Invalid Team")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(teamSeedDto -> {
                    Team team = modelMapper.map(teamSeedDto, Team.class);

                    Town town = townServiceImpl.findByName(team.getTown().getName());
                    team.setTown(town);

                    return team;
                })
                .forEach(teamRepository::save);


        return sb.toString();
    }

    @Override
    public Team findByName(String name) {
        return teamRepository.findByName(name);
    }

    private boolean teamNameIsNotInDB(String name) {
        return teamRepository.existsByName(name);
    }
}
