package com.mockito.basic.exercise5;

/**
 * Basic Exercise 5: Mocking and Stubbing with Multiple Returns
 * ReportService calls DataSource.fetchRecord() multiple times to aggregate records.
 */
public class ReportService {

    private final DataSource dataSource;

    public ReportService(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public String getFirstRecord() {
        return dataSource.fetchRecord();
    }

    public String getSecondRecord() {
        return dataSource.fetchRecord();
    }
}
