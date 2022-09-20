package com.example.spotifyplaylistapp.service;

import com.example.spotifyplaylistapp.model.binding.SongDTO;
import com.example.spotifyplaylistapp.model.entity.SongEntity;
import com.example.spotifyplaylistapp.model.entity.StyleEntity;
import com.example.spotifyplaylistapp.model.entity.UserEntity;
import com.example.spotifyplaylistapp.repository.SongRepository;
import com.example.spotifyplaylistapp.session.UserSession;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
public class SongService {

    private final SongRepository songRepository;
    private final ModelMapper modelMapper;
    private final StyleService styleService;
    private final UserSession userSession;
    private final UserService userService;

    public SongService(SongRepository songRepository, ModelMapper modelMapper,
                       StyleService styleService, UserSession userSession, 
                       UserService userService) {
        this.songRepository = songRepository;
        this.modelMapper = modelMapper;
        this.styleService = styleService;
        this.userSession = userSession;
        this.userService = userService;
    }

    public boolean addSong(SongDTO songDTO) {

        String performer = songDTO.getPerformer();
        String styleName = songDTO.getStyle();

        //if exists in DB, we need performer
        if (songRepository.findByPerformer(performer).isPresent()) {
            return false;
        }

        // we need style name
        StyleEntity styleEntity = styleService.findStyleByStyleName(styleName);

        SongEntity newSong = modelMapper.map(songDTO, SongEntity.class);

        //set style!!!
        newSong.setStyle(styleEntity);

        songRepository.save(newSong);

        return true;
    }

    public void saveSongToPlaylist(Long songId) {
        
        //if song exist in DB
        SongEntity songEntity = songRepository.findById(songId).orElse(null);
        
        //its currentUser
        Long sessionId = userSession.getId();

        //if we have user??, search by ID
        UserEntity userEntity = userService.findUserById(sessionId);

        if (userEntity.getSongs().contains(songEntity)) {
            return;
        }

        userEntity.getSongs().add(songEntity);
        userService.saveUser(userEntity);
    }

    public void removeSongFromPlaylist() {
        Long sessionId = userSession.getId();
        UserEntity user = userService.findUserById(sessionId);

        user.setSongs(new ArrayList<>());
        userService.saveUser(user);
    }

    public List<SongEntity> findAllPopSongs() {
        return songRepository
                .findAll()
                .stream()
                .filter(song -> song.getStyle().getStyleName().name().toUpperCase(Locale.ROOT).equals("POP"))
                .collect(Collectors.toList());
    }

    public List<SongEntity> findAllRockSongs() {
        return songRepository
                .findAll()
                .stream()
                .filter(song -> song.getStyle().getStyleName().name().toUpperCase(Locale.ROOT).equals("ROCK"))
                .collect(Collectors.toList());
    }

    public List<SongEntity> findAllJazzSongs() {
        return songRepository
                .findAll()
                .stream()
                .filter(song -> song.getStyle().getStyleName().name().toUpperCase(Locale.ROOT).equals("JAZZ"))
                .collect(Collectors.toList());
    }
}
