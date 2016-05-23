package org.vmk.db;

import static org.junit.Assert.assertEquals;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.junit.Test;

public class ReadedStringTest {

    @Test
    public void inputStream() throws IOException, URISyntaxException {
        final String testFile = "/stream-reader.test";
        final byte[] exp = Files.readAllBytes(
            Paths.get(
                ReadedStringTest.class.getResource(testFile).toURI()
            )
        );
        final String expStr = new String(exp);
        final String test = new ReadedString(
            ReadedStringTest.class.getResourceAsStream(testFile)
        ).toString();
        assertEquals("Text is different",
            expStr,
            test
        );
    }

    @Test
    public void file() throws IOException, URISyntaxException {
        final String testFile = "/stream-reader.test";
        final byte[] exp = Files.readAllBytes(
            Paths.get(
                ReadedStringTest.class.getResource(testFile).toURI()
            )
        );
        final String expStr = new String(exp);
        final String test = new ReadedString(
            Paths.get(
                ReadedStringTest.class.getResource(testFile).toURI()
            ).toFile()
        ).toString();
        assertEquals("Text is different",
            expStr,
            test
        );
    }
}
 