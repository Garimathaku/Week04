package week4.day5.junit;
import com.week4.day_5.junit.PerformanceTestingUsingTimeout;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;
import java.util.concurrent.TimeUnit;

class PerformanceTestingUsingTimeoutTest {
    private final PerformanceTestingUsingTimeout tester = new PerformanceTestingUsingTimeout();

    @Test
    @Timeout(value = 2, unit = TimeUnit.SECONDS) // Fail if execution takes more than 2 seconds
    void testLongRunningTaskTimeout() {
        String result = tester.longRunningTask();
        assertEquals("Task Completed", result, "Method took too long!");
    }
}

