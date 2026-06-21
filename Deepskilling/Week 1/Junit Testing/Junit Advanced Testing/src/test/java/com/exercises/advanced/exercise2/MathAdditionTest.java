package com.exercises.advanced.exercise2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Advanced Exercise 2: Test Suites and Categories
 * Tests for addition operations in MathUtils, included in AllTests suite.
 */
public class MathAdditionTest {

    private final MathUtils math = new MathUtils();

    @Test
    void testAddPositiveNumbers() {
        assertEquals(7, math.add(3, 4));
    }

    @Test
    void testAddNegativeNumbers() {
        assertEquals(-5, math.add(-2, -3));
    }

    @Test
    void testAddZero() {
        assertEquals(10, math.add(10, 0));
    }
}
