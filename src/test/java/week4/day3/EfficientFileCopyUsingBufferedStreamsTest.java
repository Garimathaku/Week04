package week4.day3;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import com.week4.day_3.EfficientFileCopyUsingBufferedStreams;

public class EfficientFileCopyUsingBufferedStreamsTest {

    @Test
    void testBufferedFileCopy() throws IOException {
        String sourceFile = "src/main/java/com/week4/day_3/Source.txt";
        String destBuffered = "src/test/java/week4/day3/desti.txt";

        File source = new File(sourceFile);
        assertTrue(source.exists(), "Source file should exist before copying");

        EfficientFileCopyUsingBufferedStreams.copyWithBufferedStreams(sourceFile, destBuffered);

        File destination = new File(destBuffered);
        assertTrue(destination.exists(), "Buffered copy destination file should exist after copying");

        byte[] sourceContent = Files.readAllBytes(Paths.get(sourceFile));
        byte[] destinationContent = Files.readAllBytes(Paths.get(destBuffered));
        assertArrayEquals(sourceContent, destinationContent, "Buffered copied file contents should be identical");
    }

    @Test
    void testUnbufferedFileCopy() throws IOException {
        String sourceFile = "src/main/java/com/week4/day_3/Source.txt";
        String destUnbuffered = "src/test/java/week4/day3/desti.txt";

        File source = new File(sourceFile);
        assertTrue(source.exists(), "Source file should exist before copying");

        EfficientFileCopyUsingBufferedStreams.copyWithUnbufferedStreams(sourceFile, destUnbuffered);

        File destination = new File(destUnbuffered);
        assertTrue(destination.exists(), "Unbuffered copy destination file should exist after copying");

        byte[] sourceContent = Files.readAllBytes(Paths.get(sourceFile));
        byte[] destinationContent = Files.readAllBytes(Paths.get(destUnbuffered));
        assertArrayEquals(sourceContent, destinationContent, "Unbuffered copied file contents should be identical");
    }
}