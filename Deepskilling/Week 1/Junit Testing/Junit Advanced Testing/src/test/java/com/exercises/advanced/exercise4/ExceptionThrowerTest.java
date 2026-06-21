package com.exercises.advanced.exercise4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Advanced Exercise 4: Exception Testing
 * ExceptionThrowerTest verifies that methods throw the correct exceptions using assertThrows.
 */
public class ExceptionThrowerTest {

    private final ExceptionThrower thrower = new ExceptionThrower();

    @Test
    void testThrowsNullPointerExceptionForNullInput() {
        NullPointerException ex = assertThrows(
                NullPointerException.class,
                () -> thrower.throwException(null)
        );
        assertTrue(ex.getMessage().contains("null"));
    }

    @Test
    void testThrowsIllegalArgumentExceptionForEmptyInput() {
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> thrower.throwException("")
        );
        assertEquals("Input must not be empty.", ex.getMessage());
    }

    @Test
    void testThrowsRuntimeExceptionForErrorKeyword() {
        RuntimeException ex = assertThrows(
                RuntimeException.class,
                () -> thrower.throwException("error")
        );
        assertEquals("Triggered runtime error.", ex.getMessage());
    }

    @Test
    void testNoExceptionForValidInput() {
        assertDoesNotThrow(() -> thrower.throwException("hello"));
    }

    @Test
    void testParseAndDoubleThrowsForNonNumericString() {
        assertThrows(
                NumberFormatException.class,
                () -> thrower.parseAndDouble("abc")
        );
    }

    @Test
    void testParseAndDoubleReturnsCorrectResult() {
        int result = thrower.parseAndDouble("5");
        assertEquals(10, result);
    }
}
