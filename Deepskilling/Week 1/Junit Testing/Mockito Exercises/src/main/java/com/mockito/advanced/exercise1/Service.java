package com.mockito.advanced.exercise1;

/**
 * Advanced Exercise 1: Mocking Databases and Repositories
 * Service processes raw repository data before returning it to the caller.
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
