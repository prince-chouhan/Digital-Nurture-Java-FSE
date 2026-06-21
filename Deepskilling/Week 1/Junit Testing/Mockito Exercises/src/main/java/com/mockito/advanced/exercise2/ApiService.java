package com.mockito.advanced.exercise2;

/**
 * Advanced Exercise 2: Mocking External Services (RESTful APIs)
 * ApiService delegates GET and POST operations to RestClient and enriches the response.
 */
public class ApiService {

    private final RestClient restClient;

    public ApiService(RestClient restClient) {
        this.restClient = restClient;
    }

    public String fetchData() {
        return "Fetched " + restClient.getResponse();
    }

    public String sendData(String payload) {
        return "Sent: " + restClient.postData(payload);
    }
}
