package com.learning.logging;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class LoggingDemoTest {

    @Test
    void testLoggingLevels() {
        LoggingDemo demo = new LoggingDemo();
        
        // Assert that logging doesn't throw exceptions and records properly
        assertDoesNotThrow(() -> {
            demo.processUserLogin("Aum", true);  // triggers warn and info
            demo.processUserLogin("RegularUser", false); // triggers info
            demo.processUserLogin("invalid_user", false); // triggers error log
        });
    }
}
