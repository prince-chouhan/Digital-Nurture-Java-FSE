package com.exercises.advanced.exercise1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Advanced Exercise 1: Parameterized Tests
 * Tests EvenChecker.isEven() with multiple inputs using @ParameterizedTest and @ValueSource.
 */
public class EvenCheckerTest {

    private final EvenChecker checker = new EvenChecker();

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 100, 0, -8})
    void testIsEvenWithEvenNumbers(int number) {
        assertTrue(checker.isEven(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 7, 99, -5})
    void testIsEvenWithOddNumbers(int number) {
        assertFalse(checker.isEven(number));
    }

    @ParameterizedTest
    @CsvSource({"2, true", "3, false", "10, true", "11, false", "-4, true", "-7, false"})
    void testIsEvenWithExpectedResults(int number, boolean expected) {
        boolean result = checker.isEven(number);
        if (expected) {
            assertTrue(result);
        } else {
            assertFalse(result);
        }
    }
}
