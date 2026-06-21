package com.mockito.advanced.exercise4;

/**
 * Advanced Exercise 4: Mocking Network Interactions
 * NetworkClient abstracts socket/connection-level calls that are mocked in tests.
 */
public interface NetworkClient {

    String connect();

    void disconnect();

    String sendData(String data);
}
