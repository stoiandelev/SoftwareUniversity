package com.example.softunigamestore_dto.config;

import com.example.softunigamestore_dto.model.dto.GameAddDto;
import com.example.softunigamestore_dto.model.entity.Game;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Configuration
public class ApplicationBeanConfiguration {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        //custom configuration
        modelMapper
                .typeMap(GameAddDto.class, Game.class)
                .addMappings(mapper ->
                        mapper.map(GameAddDto::getThumbnailURL,
                                Game::setImageThumbnail));

//        Converter<String, LocalDate> localDateConverter = new Converter<String, LocalDate>() {
//
//            @Override
//            public LocalDate convert(MappingContext<String, LocalDate> mappingContext) {
//                return mappingContext == null
//                        ? LocalDate.now()
//                        : LocalDate.parse(mappingContext.getSource(),
//                        DateTimeFormatter.ofPattern("dd-MM-yyyy"));
//            }
//        };
//        modelMapper.addConverter(localDateConverter);
        return modelMapper;
    }

}
