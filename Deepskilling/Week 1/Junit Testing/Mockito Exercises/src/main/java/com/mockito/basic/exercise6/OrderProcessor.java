package com.mockito.basic.exercise6;

/**
 * Basic Exercise 6: Verifying Interaction Order
 * OrderProcessor defines the steps that must be called in a specific sequence.
 */
public interface OrderProcessor {

    void validateOrder(String orderId);

    void processPayment(String orderId);

    void shipOrder(String orderId);
}
