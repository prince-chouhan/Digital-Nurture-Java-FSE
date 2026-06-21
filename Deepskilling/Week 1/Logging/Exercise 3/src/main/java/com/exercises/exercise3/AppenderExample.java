package Cognizant_DN.DeepSkilling.Week1.logging.exercise3_different_appenders.src.main.java.com.exercises.exercise3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppenderExample {

    private static final Logger logger = LoggerFactory.getLogger(AppenderExample.class);

    public static void main(String[] args) {
        logger.debug("Debug message - visible in both console and file appenders");
        logger.info("Info message - application has started successfully");
        logger.warn("Warning message - disk space is running low");
        logger.error("Error message - failed to connect to the database");

        simulateWorkflow();
    }

    private static void simulateWorkflow() {
        logger.info("Workflow started");

        for (int step = 1; step <= 3; step++) {
            logger.debug("Executing workflow step: {}", step);
        }

        logger.info("Workflow completed successfully");
    }
}
