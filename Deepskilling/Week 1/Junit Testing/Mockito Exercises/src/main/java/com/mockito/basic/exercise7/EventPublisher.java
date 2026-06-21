package com.mockito.basic.exercise7;

/**
 * Basic Exercise 7: Handling Void Methods with Exceptions
 * EventPublisher defines a void method that can be stubbed to throw exceptions in tests.
 */
public interface EventPublisher {

    void publish(String event) throws Exception;
}
