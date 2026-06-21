package com.exercises.advanced.exercise2;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

/**
 * Advanced Exercise 2: Test Suites and Categories
 * AllTests groups MathAdditionTest and MathMultiplicationTest into a single runnable suite.
 */
@Suite
@SelectClasses({MathAdditionTest.class, MathMultiplicationTest.class})
public class AllTests {
}
