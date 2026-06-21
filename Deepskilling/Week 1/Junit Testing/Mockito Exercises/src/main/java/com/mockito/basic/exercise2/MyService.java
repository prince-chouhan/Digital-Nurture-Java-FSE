package com.mockito.basic.exercise2;

/**
 * Basic Exercise 2: Verifying Interactions
 * MyService calls ExternalApi.getData(); the test verifies this interaction occurred.
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
