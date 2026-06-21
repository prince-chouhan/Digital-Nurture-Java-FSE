package com.mockito.basic.exercise5;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Basic Exercise 5: Mocking and Stubbing with Multiple Returns
 */
public class ReportServiceTest {

    @Test
    void testMultipleReturnValues() {
        DataSource mockDataSource = Mockito.mock(DataSource.class);

        when(mockDataSource.fetchRecord())
                .thenReturn("Record A")
                .thenReturn("Record B");

        ReportService reportService = new ReportService(mockDataSource);

        assertEquals("Record A", reportService.getFirstRecord());
        assertEquals("Record B", reportService.getSecondRecord());
    }

    @Test
    void testThirdCallReturnsLastStubbedValue() {
        DataSource mockDataSource = Mockito.mock(DataSource.class);

        when(mockDataSource.fetchRecord())
                .thenReturn("First")
                .thenReturn("Second");

        ReportService reportService = new ReportService(mockDataSource);

        reportService.getFirstRecord();
        reportService.getSecondRecord();

        assertEquals("Second", mockDataSource.fetchRecord());
    }
}
