package softuni.exam.instagraphlite.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.dto.UserSeedDto;
import softuni.exam.instagraphlite.models.entity.User;
import softuni.exam.instagraphlite.repository.UserRepository;
import softuni.exam.instagraphlite.service.PictureService;
import softuni.exam.instagraphlite.service.UserService;
import softuni.exam.instagraphlite.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Comparator;

@Service
public class UserServiceImpl implements UserService {

    public static final String USERS_FILE_PATH = "src/main/resources/files/users.json";

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final PictureService pictureService;

    public UserServiceImpl(UserRepository userRepository,
                           ModelMapper modelMapper,
                           Gson gson,
                           ValidationUtil validationUtil,
                           PictureService pictureService) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.pictureService = pictureService;
    }

    @Override
    public boolean areImported() {
        return userRepository.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return Files
                .readString(Path.of(USERS_FILE_PATH));
    }

    @Override
    public String importUsers() throws IOException {
        StringBuilder sb = new StringBuilder();

        Arrays.stream(gson
                        .fromJson(readFromFileContent(), UserSeedDto[].class))
                .filter(userSeedDto -> {
                    //валидацията е минала, user не същестува, и има такъв път на снимката
                    boolean isValid = validationUtil.isValid(userSeedDto)
                            && !isEntityExists(userSeedDto.getUsername())
                            && pictureService.IsEntityExists(userSeedDto.getProfilePicture());
                    sb
                            .append(isValid
                                    ? String.format("Successfully imported User: %s",
                                    userSeedDto.getUsername())
                                    : "Invalid User")
                            .append(System.lineSeparator());
                    return isValid;
                })
                .map(userSeedDto -> {
                    //set path, първо ги намираме
                    User user = modelMapper.map(userSeedDto, User.class);
                    user.setProfilePicture(pictureService.findByPath(userSeedDto.getProfilePicture()));

                    return user;
                })
                .forEach(userRepository::save);

        return sb.toString();
    }

    @Override
    public boolean isEntityExists(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public User findByUserName(String username) {
        return userRepository
                .findByUsername(username)
                .orElse(null);
    }

    @Override
    public String exportUsersWithTheirPosts() {
        StringBuilder sb = new StringBuilder();
        userRepository.findAllByPostsCountDescThenByUserIdAsc()
                .forEach(user -> {
                    sb
                            .append(String.format("""
                                            User: %s
                                            Post count: %d
                                            """,
                                    user.getUsername(),
                                    user.getPosts().size()));

                    user.getPosts()
                            .stream()
                            .sorted(Comparator.comparingDouble(a -> a.getPicture().getSize()))
                            .forEach(post -> {
                                sb
                                        .append(String.format("""
                                                        "==Post Details:"
                                                        "----Caption: %s"
                                                        "----Picture Size: %.2f"))""",
                                                post.getCaption(),
                                                post.getPicture().getSize()));
                            });


                });

        return sb.toString();
    }
}
