package com.example.advquerying;

import com.example.advquerying.entities.Size;
import com.example.advquerying.repositories.ShampooRepository;
import com.example.advquerying.services.impl.ShampooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunner implements org.springframework.boot.CommandLineRunner {

    private final ShampooRepository shampooRepository;
    private final ShampooService shampooService;

    @Autowired
    public CommandLineRunner(ShampooRepository shampooRepository,
                             ShampooService shampooService) {
        this.shampooRepository = shampooRepository;
        this.shampooService = shampooService;
    }


    @Override
    public void run(String... args) {

        this.shampooService.selectBySizeOrLabelId(Size.MEDIUM, 10)
                .forEach(System.out::println);


//        this.shampooService.selectBySize(Size.MEDIUM)
//                .forEach(System.out::println);


    }

}
