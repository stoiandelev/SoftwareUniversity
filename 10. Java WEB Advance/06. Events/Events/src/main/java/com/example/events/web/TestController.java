package com.example.events.web;

import com.example.events.OrderCreatedEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class TestController {

    private final ApplicationEventPublisher eventPublisher;

    public TestController(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }


    @GetMapping("/create-order")
    public String test() {

        OrderCreatedEvent event = new OrderCreatedEvent(this, UUID.randomUUID().toString());
        eventPublisher.publishEvent(event);


        return "test";
    }
}
