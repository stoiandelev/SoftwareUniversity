package softuni.exam.instagraphlite.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.dto.PictureSeedDto;
import softuni.exam.instagraphlite.models.entity.Picture;
import softuni.exam.instagraphlite.repository.PictureRepository;
import softuni.exam.instagraphlite.service.PictureService;
import softuni.exam.instagraphlite.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
public class PictureServiceImpl implements PictureService {

    public static final String PICTURES_FILE_PATH = "src/main/resources/files/pictures.json";

    private final PictureRepository pictureRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;

    public PictureServiceImpl(PictureRepository pictureRepository,
                              ModelMapper modelMapper,
                              Gson gson,
                              ValidationUtil validationUtil) {
        this.pictureRepository = pictureRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return pictureRepository.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return Files
                .readString(Path.of(PICTURES_FILE_PATH));
    }

    @Override
    public String importPictures() throws IOException {
        StringBuilder sb = new StringBuilder();

        Arrays.stream(gson
                        .fromJson(readFromFileContent(), PictureSeedDto[].class))
                .filter(pictureSeedDto -> {
                    //правим проверка за уникалността на filePath
                    boolean isValid = validationUtil.isValid(pictureSeedDto)
                            && !IsEntityExists(pictureSeedDto.getPath());
                    sb
                            .append(isValid
                                    ? String.format("Successfully imported Picture, with size %.2f"
                                    , pictureSeedDto.getSize())
                                    : "Invalid Picture")
                            .append(System.lineSeparator());
                    return isValid;
                })
                .map(pictureSeedDto -> modelMapper.map(pictureSeedDto, Picture.class))
                .forEach(pictureRepository::save);

        return sb.toString();
    }

    @Override
    public boolean IsEntityExists(String path) {
        return pictureRepository.existsByPath(path);
    }


    @Override
    public Picture findByPath(String path) {
        return pictureRepository
                .findByPath(path)
                .orElse(null);
    }


    @Override
    public String exportPictures() {
        StringBuilder sb = new StringBuilder();

        pictureRepository.findAllBySizeGreaterThanOrderBySizeAsc(30000D)
                .forEach(picture -> {
                    sb
                            .append(String.format("%.2f – %s",
                                    picture.getSize(),
                                    picture.getPath()))
                            .append(System.lineSeparator());
                });

        return sb.toString();
    }

}
