package com.example.football.service.impl;

import com.example.football.models.dto.PlayerSeedRootDto;
import com.example.football.models.entity.Player;
import com.example.football.models.entity.Stat;
import com.example.football.models.entity.Team;
import com.example.football.models.entity.Town;
import com.example.football.repository.PlayerRepository;
import com.example.football.service.PlayerService;
import com.example.football.util.ValidationUtil;
import com.example.football.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlayerServiceImpl implements PlayerService {


    private static final String PLAYER_FILE_PATH = "/Users/stoiandelev/Desktop/skeleton/skeleton/src/main/resources/files/xml/players.xml";

    private final PlayerRepository playerRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final XmlParser xmlParser;

    private final TownServiceImpl townServiceImpl;
    private final TeamServiceImpl teamServiceImpl;
    private final StatServiceImpl statServiceImpl;

    public PlayerServiceImpl(PlayerRepository playerRepository,
                             ModelMapper modelMapper,
                             ValidationUtil validationUtil,
                             XmlParser xmlParser,
                             TownServiceImpl townServiceImpl,
                             TeamServiceImpl teamServiceImpl,
                             StatServiceImpl statServiceImpl) {
        this.playerRepository = playerRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.xmlParser = xmlParser;
        this.townServiceImpl = townServiceImpl;
        this.teamServiceImpl = teamServiceImpl;
        this.statServiceImpl = statServiceImpl;
    }


    @Override
    public boolean areImported() {
        return playerRepository.count() > 0;
    }

    @Override
    public String readPlayersFileContent() throws IOException {
        return Files
                .readString(Path.of(PLAYER_FILE_PATH));
    }

    @Override
    public String importPlayers() throws JAXBException, FileNotFoundException {
        StringBuilder sb = new StringBuilder();

//        PlayerSeedRootDto playerSeedRootDto = xmlParser
//                .fromFile(PLAYER_FILE_PATH, PlayerSeedRootDto.class);

        xmlParser
                .fromFile(PLAYER_FILE_PATH, PlayerSeedRootDto.class)
                .getPlayers()
                .stream()
                .filter(playerSeedDto -> {
                    boolean isValid = validationUtil.isValid(playerSeedDto)
                            && !emailIsNotExistInDb(playerSeedDto.getEmail());
                    sb
                            .append(isValid
                                    ? String.format("Successfully imported Player %s %s - %s",
                                    playerSeedDto.getFirstName(),
                                    playerSeedDto.getLastName(),
                                    playerSeedDto.getPosition())
                                    : "Invalid Player")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(playerSeedDto -> {
                    Player player = modelMapper.map(playerSeedDto, Player.class);

                    Town town = townServiceImpl.findByName(player.getTown().getName());
                    Team team = teamServiceImpl.findByName(player.getTeam().getName());
                    Optional<Stat> stat = statServiceImpl.findById(player.getStat().getId());

                    player.setTown(town);
                    player.setTeam(team);
                    player.setStat(stat.get());

                    return player;

                })
                .forEach(playerRepository::save);

        return sb.toString();
    }

    private boolean emailIsNotExistInDb(String email) {
        return playerRepository.existsByEmail(email);
    }

    @Override
    public String exportBestPlayers() {
        LocalDate before = LocalDate.of(2003, 1, 1);
        LocalDate after = LocalDate.of(1995, 1, 1);


        List<Player> players = this.playerRepository
                .findByBirthDateBetweenOrderByStatShootingDescStatPassingDescStatEnduranceDescLastNameAsc(after, before);


        return players
                .stream()
                .map(Player::toString)
                .collect(Collectors.joining("\n"));
    }
}
