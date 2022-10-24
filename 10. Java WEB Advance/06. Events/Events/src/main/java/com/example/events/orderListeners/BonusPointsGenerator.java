package com.example.events.orderListeners;

import com.example.events.ApplicationListenerTest;
import com.example.events.OrderCreatedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class BonusPointsGenerator {

    private Logger LOGGER = LoggerFactory.getLogger(BonusPointsGenerator.class);

    @EventListener(OrderCreatedEvent.class)
    public void onOrderCreated(OrderCreatedEvent orderCreatedEvent) {
        LOGGER.info("Order no {} has been created! I am going to give bonus" +
                " points ot the client", orderCreatedEvent.getOrderId());

        //TODO give bonus point to the client.
    }

}
