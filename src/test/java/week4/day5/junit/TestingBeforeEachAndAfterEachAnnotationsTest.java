package week4.day5.junit;
import com.week4.day_5.junit.TestingBeforeEachAndAfterEachAnnotations;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestingBeforeEachAndAfterEachAnnotationsTest {
    private TestingBeforeEachAndAfterEachAnnotations db;

    @BeforeEach
    void setUp() {
        db = new TestingBeforeEachAndAfterEachAnnotations();
        db.connect();
    }

    @Test
    void testConnectionIsEstablished() {
        assertTrue(db.isConnected(), "Database should be connected.");
    }

    @AfterEach
    void tearDown() {
        db.disconnect();
        assertFalse(db.isConnected(), "Database should be disconnected.");
    }
}
