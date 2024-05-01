package customMethods;

import org.testng.Reporter;

public class custom_logger {
    private static StringBuilder logBuffer = new StringBuilder();

    public static void log(String message) {
        logBuffer.append(message).append("<br/>");
        Reporter.log(message); // Optional: Also log to TestNG Reporter
    }

    public static void flush() {
        Reporter.log(logBuffer.toString());
        logBuffer.setLength(0); // Clear the buffer
    }
}
