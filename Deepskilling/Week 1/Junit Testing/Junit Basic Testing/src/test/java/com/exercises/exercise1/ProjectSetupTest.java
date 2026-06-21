package com.exercises.exercise1;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Exercise 1: Setting Up JUnit
 */
public class ProjectSetupTest {

    @Test
    public void testProjectIsSetUp() {
        ProjectSetup setup = new ProjectSetup();
        String greeting = setup.getGreeting();

        assertNotNull("Greeting should not be null", greeting);
        assertEquals("JUnit project is set up and ready!", greeting);
        System.out.println("Exercise 1 PASSED: " + greeting);
    }
}
