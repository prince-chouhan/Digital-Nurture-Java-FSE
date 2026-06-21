package com.exercises.advanced.exercise2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Advanced Exercise 2: Test Suites and Categories
 * Tests for multiplication and sign operations in MathUtils, included in AllTests suite.
 */
public class MathMultiplicationTest {

    private final MathUtils math = new MathUtils();

    @Test
    void testMultiplyTwoPositives() {
        assertEquals(12, math.multiply(3, 4));
    }

    @Test
    void testMultiplyByZero() {
        assertEquals(0, math.multiply(99, 0));
    }

    @Test
    void testIsPositive() {
        assertTrue(math.isPositive(5));
    }
}
