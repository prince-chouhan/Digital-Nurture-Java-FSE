package com.mockito.advanced.exercise5;

/**
 * Advanced Exercise 5: Mocking Multiple Return Values
 * Service calls Repository.getData() on each processData() invocation,
 * allowing consecutive calls to return different mocked values.
 */
public class Service {

    private final Repository repository;

    public Service(Repository repository) {
        this.repository = repository;
    }

    public String processData() {
        return "Processed " + repository.getData();
    }
}
