package com.mockito.advanced.exercise1;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Advanced Exercise 1: Mocking Databases and Repositories
 * Stubs the repository with mock data and verifies the service processes it correctly.
 */
public class ServiceTest {

    @Test
    void testServiceWithMockRepository() {
        Repository mockRepository = Mockito.mock(Repository.class);

        when(mockRepository.getData()).thenReturn("Mock Data");

        Service service = new Service(mockRepository);
        String result = service.processData();

        assertEquals("Processed Mock Data", result);
        verify(mockRepository).getData();
    }

    @Test
    void testServiceWithDifferentRepositoryData() {
        Repository mockRepository = Mockito.mock(Repository.class);

        when(mockRepository.getData()).thenReturn("User Records");

        Service service = new Service(mockRepository);

        assertEquals("Processed User Records", service.processData());
    }
}
