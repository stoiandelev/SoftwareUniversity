package com.example.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentService.class);

    @Cacheable("students")
    public List<Student> findAllStudent() {
        //Do something very time intensive here, e.g. connect to remote service
        //to download the students

        LOGGER.info("I am doing some complicated staff....");

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            Thread.interrupted();
        }

        LOGGER.info("Completed calculation finished....");

        return List.of(
                new Student(1L, "Pesho", 34),
                new Student(2L, "Anna", 30)
        );
    }

}
