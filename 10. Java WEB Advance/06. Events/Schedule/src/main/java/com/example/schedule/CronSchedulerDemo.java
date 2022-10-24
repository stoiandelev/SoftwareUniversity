package com.example.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


@Component
public class CronSchedulerDemo {

    private static final Logger LOGGER = LoggerFactory.getLogger(CronSchedulerDemo.class);

    //Every 10 sec user cron site
    @Scheduled(cron = "*/10 * * * * *")
    public void showTimeWithCron() {
        LOGGER.info("Hello from cron scheduler at {}", LocalDateTime.now());
    }


}
