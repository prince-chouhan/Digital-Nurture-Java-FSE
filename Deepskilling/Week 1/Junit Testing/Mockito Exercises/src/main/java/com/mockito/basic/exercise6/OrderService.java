package com.mockito.basic.exercise6;

/**
 * Basic Exercise 6: Verifying Interaction Order
 * OrderService orchestrates validate → pay → ship in strict sequence.
 */
public class OrderService {

    private final OrderProcessor processor;

    public OrderService(OrderProcessor processor) {
        this.processor = processor;
    }

    public void placeOrder(String orderId) {
        processor.validateOrder(orderId);
        processor.processPayment(orderId);
        processor.shipOrder(orderId);
    }
}
