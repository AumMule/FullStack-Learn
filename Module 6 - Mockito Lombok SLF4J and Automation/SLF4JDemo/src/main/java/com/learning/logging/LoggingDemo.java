package com.learning.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingDemo {
    private static final Logger logger = LoggerFactory.getLogger(LoggingDemo.class);

    public void processUserLogin(String username, boolean isFirstTime) {
        // Parameterized Logging for performance efficiency
        logger.info("Processing login for user: {}", username);

        if (isFirstTime) {
            // Warn Level Logging
            logger.warn("User {} is logging in for the first time. Security checks required.", username);
        }

        try {
            if ("invalid_user".equals(username)) {
                throw new IllegalArgumentException("User database lookup failed.");
            }
            logger.info("User {} logged in successfully.", username);
        } catch (Exception e) {
            // Error Level Logging with Exception Stack Trace
            logger.error("Failed to log in user: {}. Error message: {}", username, e.getMessage(), e);
        }
    }
}
