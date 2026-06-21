package com.mockito.advanced.exercise3;

/**
 * Advanced Exercise 3: Mocking File I/O
 * FileReader abstracts reading file content so it can be mocked without touching the filesystem.
 */
public interface FileReader {

    String read();
}
