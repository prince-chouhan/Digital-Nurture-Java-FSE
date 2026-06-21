package com.mockito.basic.exercise1;

/**
 * Basic Exercise 1: Mocking and Stubbing
 * MyService depends on ExternalApi and delegates data fetching to it.
 */
public class MyService {

    private final ExternalApi externalApi;

    public MyService(ExternalApi externalApi) {
        this.externalApi = externalApi;
    }

    public String fetchData() {
        return externalApi.getData();
    }
}
