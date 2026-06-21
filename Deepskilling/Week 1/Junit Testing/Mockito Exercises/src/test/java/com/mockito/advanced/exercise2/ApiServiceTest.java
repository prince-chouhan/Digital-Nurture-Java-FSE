package com.mockito.advanced.exercise2;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Advanced Exercise 2: Mocking External Services (RESTful APIs)
 */
public class ApiServiceTest {

    @Test
    void testServiceWithMockRestClient() {
        RestClient mockRestClient = Mockito.mock(RestClient.class);

        when(mockRestClient.getResponse()).thenReturn("Mock Response");

        ApiService apiService = new ApiService(mockRestClient);
        String result = apiService.fetchData();

        assertEquals("Fetched Mock Response", result);
        verify(mockRestClient).getResponse();
    }

    @Test
    void testSendDataWithMockPostCall() {
        RestClient mockRestClient = Mockito.mock(RestClient.class);

        when(mockRestClient.postData("payload123")).thenReturn("201 Created");

        ApiService apiService = new ApiService(mockRestClient);
        String result = apiService.sendData("payload123");

        assertEquals("Sent: 201 Created", result);
        verify(mockRestClient).postData("payload123");
    }
}
