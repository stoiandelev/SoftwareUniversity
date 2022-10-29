package com.example.aop.modifying;

import com.example.aop.basic.BasicExampleAspect;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Aspect
@Component
@ConditionalOnProperty(name = "examples.modifying.enabled", havingValue = "true")
public class ModifyingAspect {



    @Pointcut("execution( * com.example.aop.Student.concat(..) )")
    public void concatPointCut() {
    }

    @Around("concatPointCut() && args(a, b)")
    public Object modify(ProceedingJoinPoint pjp, String a, String b) throws Throwable {
        Object returnValue = pjp.proceed(new Object[]{
                "[" + a + "] - ",
                "[" + b + "]"
        });

        return "(" + returnValue + ")";
    }

    //ProceedingJoinPoint can insert only on Around Advice.
    //С него мога да извикам метода и да му променя по някакъв начин аргументите,

}
