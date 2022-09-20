package com.example.spotifyplaylistapp.service;

import com.example.spotifyplaylistapp.model.entity.StyleEntity;
import com.example.spotifyplaylistapp.model.enums.StyleEnum;
import com.example.spotifyplaylistapp.repository.StyleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StyleService {

    private final StyleRepository styleRepository;

    public StyleService(StyleRepository styleRepository) {
        this.styleRepository = styleRepository;
    }

    public List<StyleEntity> findAllStyles() {
        return styleRepository.findAll();
    }

    public StyleEntity findStyleByStyleName(String styleName) {
        StyleEnum styleEnum = StyleEnum.valueOf(styleName);
        return styleRepository.findStyleByStyleName(styleEnum);
    }
}
