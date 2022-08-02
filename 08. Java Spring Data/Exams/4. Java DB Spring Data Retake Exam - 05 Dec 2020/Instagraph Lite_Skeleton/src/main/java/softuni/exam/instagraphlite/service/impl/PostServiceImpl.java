package softuni.exam.instagraphlite.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.dto.PostSeedRootDto;
import softuni.exam.instagraphlite.models.entity.Post;
import softuni.exam.instagraphlite.repository.PostRepository;
import softuni.exam.instagraphlite.service.PictureService;
import softuni.exam.instagraphlite.service.PostService;
import softuni.exam.instagraphlite.service.UserService;
import softuni.exam.instagraphlite.util.ValidationUtil;
import softuni.exam.instagraphlite.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class PostServiceImpl implements PostService {

    public static final String POSTS_FILE_PATH = "src/main/resources/files/posts.xml";

    private final PostRepository postRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final XmlParser xmlParser;

    private final UserService userService;
    private final PictureService pictureService;

    public PostServiceImpl(PostRepository postRepository,
                           ModelMapper modelMapper,
                           ValidationUtil validationUtil,
                           XmlParser xmlParser,
                           UserService userService,
                           PictureService pictureService) {
        this.postRepository = postRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.xmlParser = xmlParser;
        this.userService = userService;
        this.pictureService = pictureService;
    }

    @Override
    public boolean areImported() {
        return postRepository.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return Files
                .readString(Path.of(POSTS_FILE_PATH));
    }

    @Override
    public String importPosts() throws IOException, JAXBException {
        StringBuilder sb = new StringBuilder();

        xmlParser.fromFile(POSTS_FILE_PATH, PostSeedRootDto.class)
                .getPosts()
                .stream()
                .filter(postSeedDto -> {
                    //искаме да има USER и снимката да съществува в базата
                    boolean isValid = validationUtil.isValid(postSeedDto)
                            && userService.isEntityExists(postSeedDto.getUser().getUsername())
                            && pictureService.IsEntityExists(postSeedDto.getPicture().getPath());

                    sb
                            .append(isValid
                                    ? String.format("Successfully imported Post, made by %s",
                                    postSeedDto.getUser().getUsername())
                                    : "Invalid Post")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(postSeedDto -> {
                    Post post = modelMapper.map(postSeedDto, Post.class);

                    post.setUser(userService.findByUserName(postSeedDto.getUser().getUsername()));
                    post.setPicture(pictureService.findByPath(postSeedDto.getPicture().getPath()));

                    return post;
                })
                .forEach(postRepository::save);


        return sb.toString();
    }
}
