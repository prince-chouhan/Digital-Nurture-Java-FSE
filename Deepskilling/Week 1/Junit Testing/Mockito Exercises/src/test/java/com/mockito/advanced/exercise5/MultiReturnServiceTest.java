package com.mockito.advanced.exercise5;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

/**
 * Advanced Exercise 5: Mocking Multiple Return Values
 */
public class MultiReturnServiceTest {

    @Test
    void testServiceWithMultipleReturnValues() {
        Repository mockRepository = Mockito.mock(Repository.class);

        when(mockRepository.getData())
                .thenReturn("First Mock Data")
                .thenReturn("Second Mock Data");

        Service service = new Service(mockRepository);

        String firstResult = service.processData();
        String secondResult = service.processData();

        assertEquals("Processed First Mock Data", firstResult);
        assertEquals("Processed Second Mock Data", secondResult);

        verify(mockRepository, times(2)).getData();
    }

    @Test
    void testThirdCallFallsBackToLastStubbedValue() {
        Repository mockRepository = Mockito.mock(Repository.class);

        when(mockRepository.getData())
                .thenReturn("First Mock Data")
                .thenReturn("Second Mock Data");

        Service service = new Service(mockRepository);

        service.processData();
        service.processData();
        String thirdResult = service.processData();

        assertEquals("Processed Second Mock Data", thirdResult);
        verify(mockRepository, times(3)).getData();
    }
}
