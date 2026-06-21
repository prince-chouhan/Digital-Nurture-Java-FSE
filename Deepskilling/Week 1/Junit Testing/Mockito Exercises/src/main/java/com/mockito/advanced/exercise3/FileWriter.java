package com.mockito.advanced.exercise3;

/**
 * Advanced Exercise 3: Mocking File I/O
 * FileWriter abstracts writing file content so it can be mocked and verified in tests.
 */
public interface FileWriter {

    void write(String content);
}
