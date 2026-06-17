public class Logger {
    // Private static instance of the class
    private static Logger instance;

    // Private constructor to prevent instantiation from other classes
    private Logger() {
        System.out.println("Logger initialized.");
    }

    // Public static method to get the single instance of the class
    // Thread-safe implementation using double-checked locking
    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    // Log message
    public void log(String message) {
        System.out.println("[LOG] " + message);
    }
}
