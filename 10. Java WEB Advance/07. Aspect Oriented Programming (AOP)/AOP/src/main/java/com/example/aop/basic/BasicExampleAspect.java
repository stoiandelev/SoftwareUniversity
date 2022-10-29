package com.example.aop.basic;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;


@Component
@Aspect
@ConditionalOnProperty(name = "basic.enabled.enabled", havingValue = "true")
public class BasicExampleAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(BasicExampleAspect.class);

    //Aspect is class who include Advice.
    // body on this method with pointcut don't do never.
    // да се изпълнява който и да е метод върху студент с каквито и да е аргументи.

    // with this Pointcut expression we select all method on class Student
    @Pointcut("execution(* com.example.aop.Student.*(..))")
    public void track() {}

    @Pointcut("execution(* com.example.aop.Student.echo(..))")
    public void trackEcho() {}


    //вътре в анотацията се използва reference към метода който съдържа pointcut expression
    // в самия Advice викаме pointcut expression
    // първо се изпълни Advice, след това се изпълни метода.

    @Before("track()")
    public void beforeAnyMethod(JoinPoint joinPoint) {
        LOGGER.info("Before calling {}", joinPoint.getSignature());
    }

    @Before("trackEcho()")
    public void beforeEcho() {
        LOGGER.info("Advice execution before calling echo.");
    }

    @AfterThrowing(pointcut = "track()", throwing = "error")
    public void trackExceptions(Throwable error) {
        LOGGER.info("I have detected Exception: ", error);
    }

    //@ConditionalOnProperty(name = "basic.enabled.enabled", havingValue = "true")
    //if is not true Spring няма да го вдигне в контекса си. Setting in application.yml

}
