package com.mockito.basic.exercise6;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import static org.mockito.Mockito.inOrder;

/**
 * Basic Exercise 6: Verifying Interaction Order
 */
public class OrderServiceTest {

    @Test
    void testOrderOfMethodCalls() {
        OrderProcessor mockProcessor = Mockito.mock(OrderProcessor.class);

        OrderService orderService = new OrderService(mockProcessor);
        orderService.placeOrder("ORD-001");

        InOrder inOrder = inOrder(mockProcessor);
        inOrder.verify(mockProcessor).validateOrder("ORD-001");
        inOrder.verify(mockProcessor).processPayment("ORD-001");
        inOrder.verify(mockProcessor).shipOrder("ORD-001");
    }

    @Test
    void testAllThreeStepsAreExecuted() {
        OrderProcessor mockProcessor = Mockito.mock(OrderProcessor.class);

        OrderService orderService = new OrderService(mockProcessor);
        orderService.placeOrder("ORD-002");

        InOrder inOrder = inOrder(mockProcessor);
        inOrder.verify(mockProcessor).validateOrder("ORD-002");
        inOrder.verify(mockProcessor).processPayment("ORD-002");
        inOrder.verify(mockProcessor).shipOrder("ORD-002");
        inOrder.verifyNoMoreInteractions();
    }
}
