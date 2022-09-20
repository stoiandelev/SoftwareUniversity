package com.example.spotifyplaylistapp.initDB;

import com.example.spotifyplaylistapp.model.entity.StyleEntity;
import com.example.spotifyplaylistapp.model.enums.StyleEnum;
import com.example.spotifyplaylistapp.repository.StyleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


import java.util.Arrays;

@Component
public class InitDB implements CommandLineRunner {

    private final StyleRepository styleRepository;

    public InitDB(StyleRepository styleRepository) {
        this.styleRepository = styleRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (styleRepository.count() == 0) {
            Arrays.stream(StyleEnum.values())
                    .forEach(styleEnum -> {
                        StyleEntity style = new StyleEntity();

                        style.setStyleName(styleEnum);

                        switch (styleEnum) {
                            case POP -> style.setDescription("POP description!");
                            case JAZZ -> style.setDescription("JAZZ description!");
                            case ROCK -> style.setDescription("ROCK description!");
                        }

                        styleRepository.save(style);
                    });

        }
    }
}
