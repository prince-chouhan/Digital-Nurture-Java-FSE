package com.exercises.exercise2;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Exercise 2: Writing Basic JUnit Tests
 *
 * Basic tests for the Calculator class covering add, subtract,
 * multiply, divide, and isEven methods.
 */
public class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    public void testAdd() {
        int result = calculator.add(3, 4);
        assertEquals("3 + 4 should equal 7", 7, result);
    }

    @Test
    public void testSubtract() {
        int result = calculator.subtract(10, 4);
        assertEquals("10 - 4 should equal 6", 6, result);
    }

    @Test
    public void testMultiply() {
        int result = calculator.multiply(3, 5);
        assertEquals("3 * 5 should equal 15", 15, result);
    }

    @Test
    public void testDivide() {
        double result = calculator.divide(10, 2);
        assertEquals("10 / 2 should equal 5.0", 5.0, result, 0.0001);
    }

    @Test(expected = ArithmeticException.class)
    public void testDivideByZeroThrowsException() {
        calculator.divide(5, 0);
    }

    @Test
    public void testIsEvenWithEvenNumber() {
        assertTrue("4 should be even", calculator.isEven(4));
    }

    @Test
    public void testIsEvenWithOddNumber() {
        assertFalse("7 should not be even", calculator.isEven(7));
    }
}
