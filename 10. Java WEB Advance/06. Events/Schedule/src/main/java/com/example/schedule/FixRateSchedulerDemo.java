package com.example.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class FixRateSchedulerDemo {

    private static final Logger LOGGER = LoggerFactory.getLogger(FixRateSchedulerDemo.class);

    //This fixed rate starts the task every N millis
    //ATTENTION: it does not wait for previous task  to end
    @Scheduled(fixedRate = 5000)
    public void showTimeWithRateDelay() {
        LOGGER.info("Hello from RATE delay scheduler at {}", LocalDateTime.now());
    }
}
