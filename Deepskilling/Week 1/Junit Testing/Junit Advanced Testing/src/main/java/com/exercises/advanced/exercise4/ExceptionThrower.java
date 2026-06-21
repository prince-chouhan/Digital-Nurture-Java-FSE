package com.exercises.advanced.exercise4;

/**
 * Advanced Exercise 4: Exception Testing
 * ExceptionThrower demonstrates methods that throw typed exceptions under specific conditions.
 */
public class ExceptionThrower {

    public void throwException(String input) {
        if (input == null) {
            throw new NullPointerException("Input must not be null.");
        }
        if (input.isEmpty()) {
            throw new IllegalArgumentException("Input must not be empty.");
        }
        if (input.equals("error")) {
            throw new RuntimeException("Triggered runtime error.");
        }
    }

    public int parseAndDouble(String numberStr) {
        int value = Integer.parseInt(numberStr);
        return value * 2;
    }
}
