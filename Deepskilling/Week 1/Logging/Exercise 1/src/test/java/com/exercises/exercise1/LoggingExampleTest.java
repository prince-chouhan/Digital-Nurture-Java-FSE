package com.exercises.exercise1;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingExampleTest {

    private static final Logger logger = LoggerFactory.getLogger(LoggingExampleTest.class);

    @Test
    public void testErrorMessageIsLogged() {
        logger.error("This is an error message");
    }

    @Test
    public void testWarnMessageIsLogged() {
        logger.warn("This is a warning message");
    }

    @Test
    public void testBothMessagesAreLogged() {
        logger.error("This is an error message");
        logger.warn("This is a warning message");
    }
}
