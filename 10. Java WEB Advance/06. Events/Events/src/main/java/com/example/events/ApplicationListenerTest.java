package com.example.events;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.ServletRequestHandledEvent;

@Component
public class ApplicationListenerTest {

    //When ApplicationListener is without parameter we receive all events.
    //When ApplicationListener is with parameter we receive only for these events.
    //We need implement ApplicationLister for these
    //We can the same with @EventListener(ServletRequestHandlerEvent.class) instead with implementation
    //on interface

    private Logger LOGGER = LoggerFactory.getLogger(ApplicationListenerTest.class);


    @EventListener(ServletRequestHandledEvent.class)
    public void onApplicationEvent(ServletRequestHandledEvent event) {
        LOGGER.info("I have receive at Event {}", event);
    }
}
