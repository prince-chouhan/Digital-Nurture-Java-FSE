package com.mockito.advanced.exercise2;

/**
 * Advanced Exercise 2: Mocking External Services (RESTful APIs)
 * RestClient abstracts HTTP calls to an external API that is mocked in tests.
 */
public interface RestClient {

    String getResponse();

    String postData(String payload);
}
