package com.exercises.exercise3;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Exercise 3: Assertions in JUnit
 *
 * Demonstrates the core JUnit 4 assertion methods:
 *   assertEquals, assertTrue, assertFalse, assertNull,
 *   assertNotNull, assertSame, assertNotSame, assertArrayEquals.
 */
public class AssertionsTest {

    private final StringUtils utils = new StringUtils();

    @Test
    public void testAssertEquals() {
        assertEquals("2 + 3 must equal 5", 5, 2 + 3);

        // String equality
        String result = utils.toUpperCase("hello");
        assertEquals("toUpperCase should return HELLO", "HELLO", result);

        assertEquals("Pi approximation", 3.14, Math.PI, 0.01);
    }

    @Test
    public void testAssertTrueAndFalse() {
        assertTrue("5 > 3 should be true", 5 > 3);
        assertFalse("5 < 3 should be false", 5 < 3);

        assertTrue("'racecar' is a palindrome", utils.isPalindrome("racecar"));
        assertFalse("'hello' is not a palindrome", utils.isPalindrome("hello"));
    }

    @Test
    public void testAssertNullAndNotNull() {
        assertNull("getNullValue() should return null", utils.getNullValue());
        assertNotNull("getNonNullValue() should not return null", utils.getNonNullValue());
        assertNull("toUpperCase(null) should return null", utils.toUpperCase(null));
    }

    @Test
    public void testAssertSameAndNotSame() {
        String a = "shared";
        String b = a;
        String c = new String("shared");

        assertSame("a and b point to the same object", a, b);
        assertNotSame("a and c are different objects", a, c);
    }


    @Test
    public void testAssertArrayEquals() {
        int[] expected = {1, 2, 3, 4, 5};
        int[] actual   = {1, 2, 3, 4, 5};
        assertArrayEquals("Arrays should be equal element-by-element", expected, actual);
    }

    @Test
    public void testAllAssertionsFromExercise() {
        assertEquals(5, 2 + 3);
        assertTrue(5 > 3);
        assertFalse(5 < 3);
        assertNull(null);
        assertNotNull(new Object());
    }
}
