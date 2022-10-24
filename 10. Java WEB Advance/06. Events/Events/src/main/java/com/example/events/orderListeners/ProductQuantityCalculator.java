package com.example.events.orderListeners;

import com.example.events.ApplicationListenerTest;
import com.example.events.OrderCreatedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ProductQuantityCalculator {

    private Logger LOGGER = LoggerFactory.getLogger(ProductQuantityCalculator.class);

    @EventListener(OrderCreatedEvent.class)
    public void onOrderCreated(OrderCreatedEvent orderCreatedEvent) {
        LOGGER.info("Order no {} has been created! I am going to calculate the" +
                " current product quantity", orderCreatedEvent.getOrderId());

        //TODO see what products had been ordered and calculate subtract product quantities.
    }
}
