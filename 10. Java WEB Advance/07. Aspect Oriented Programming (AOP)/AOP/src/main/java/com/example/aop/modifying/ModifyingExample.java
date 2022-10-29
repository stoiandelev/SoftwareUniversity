package com.example.aop.modifying;

import com.example.aop.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;


@Component
@ConditionalOnProperty(name = "examples.modifying.enabled", havingValue = "true")
public class ModifyingExample implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(ModifyingExample.class);

    private final Student student;

    public ModifyingExample(Student student) {
        this.student = student;
    }


    @Override
    public void run(String... args) throws Exception {
        String result = student.concat("A", "B");

        // if is not aspect we would expect  - result  => AB
        // if there is an aspect we would expect  - result  => ([A] -[B])

        LOGGER.info("The result from around advice is: {}", result);
    }
}
