package com.mockito.basic.exercise2;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

/**
 * Basic Exercise 2: Verifying Interactions
 * Demonstrates using verify() to assert that a mock method was called.
 */
public class MyServiceTest {

    @Test
    void testVerifyInteraction() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);

        MyService service = new MyService(mockApi);
        service.fetchData();

        verify(mockApi).getData();
    }

    @Test
    void testVerifyInteractionCalledExactlyOnce() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);

        MyService service = new MyService(mockApi);
        service.fetchData();

        verify(mockApi, times(1)).getData();
    }
}
