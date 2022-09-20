package com.example.spotifyplaylistapp.service;

import com.example.spotifyplaylistapp.model.binding.UserLoginDTO;
import com.example.spotifyplaylistapp.model.binding.UserRegisterDTO;
import com.example.spotifyplaylistapp.model.entity.SongEntity;
import com.example.spotifyplaylistapp.model.entity.UserEntity;
import com.example.spotifyplaylistapp.repository.UserRepository;
import com.example.spotifyplaylistapp.session.UserSession;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final UserSession userSession;

    public UserService(UserRepository userRepository, ModelMapper modelMapper,
                       PasswordEncoder passwordEncoder, UserSession userSession) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.userSession = userSession;
    }

    private void initUserSession(UserEntity userEntity) {
        userSession.setId(userEntity.getId());
        userSession.setUsername(userEntity.getUsername());
        userSession.setEmail(userEntity.getEmail());
    }

    public boolean registerUser(UserRegisterDTO userRegisterDTO) {

        String username = userRegisterDTO.getUsername();
        String email = userRegisterDTO.getEmail();
        String password = userRegisterDTO.getPassword();
        String confirmPassword = userRegisterDTO.getConfirmPassword();

        //find by userName or Email
        if (userRepository.findByUsernameOrEmail(username, email).isPresent()) {
            return false;
        }

        if (!password.equals(confirmPassword)) {
            return false;
        }

        userRegisterDTO.setPassword(passwordEncoder.encode(userRegisterDTO.getConfirmPassword()));

        UserEntity newUser = modelMapper.map(userRegisterDTO, UserEntity.class);
        userRepository.save(newUser);

        initUserSession(newUser);

        return true;
    }

    public boolean loginUser(UserLoginDTO userLoginDTO) {
        String username = userLoginDTO.getUsername();
        String password = userLoginDTO.getPassword();

        //if no user in DB
        Optional<UserEntity> optionalUser = userRepository.findByUsername(username);
        if (optionalUser.isEmpty()) {
            return false;
        }

        //take the user properties
        UserEntity loginUser = optionalUser.get();
        if (!passwordEncoder.matches(password, loginUser.getPassword())) {
            return false;
        }

        initUserSession(loginUser);
        return true;
    }

    public void logoutUser() {
        userSession.setId(null);
        userSession.setUsername(null);
        userSession.setEmail(null);
    }

    public UserEntity findUserById(Long sessionId) {
        return userRepository.findById(sessionId).orElse(null);
    }

    public void saveUser(UserEntity user) {
        userRepository.save(user);
    }

    public Integer findTotalPlaylistDuration() {
        Long sessionId = userSession.getId();
        UserEntity currentUser = userRepository.findById(sessionId).orElse(null);

        assert currentUser != null;

        System.out.println();

        return currentUser
                .getSongs()
                .stream()
                .map(SongEntity::getDuration)
                .reduce(0, Integer::sum);

    }

    public List<SongEntity> currentUserPlaylist() {
        Long sessionId = userSession.getId();
        UserEntity currentUser = userRepository.findById(sessionId).orElse(null);

        assert currentUser != null;

        return currentUser.getSongs();
    }
}
