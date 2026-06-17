public class SingletonTest {
    public static void main(String[] args) {
        // Retrieve two instances of Logger
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        // Print hash codes to verify they refer to the same object in memory
        System.out.println("Logger 1 HashCode: " + logger1.hashCode());
        System.out.println("Logger 2 HashCode: " + logger2.hashCode());

        // Test logging
        logger1.log("Action performed in component A.");
        logger2.log("Action performed in component B.");

        // Check if both references point to the same instance
        if (logger1 == logger2) {
            System.out.println("Test Passed: Both logger1 and logger2 refer to the exact same instance.");
        } else {
            System.out.println("Test Failed: logger1 and logger2 refer to different instances.");
        }
    }
}
