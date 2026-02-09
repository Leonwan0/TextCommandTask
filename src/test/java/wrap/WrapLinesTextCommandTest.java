package wrap;

import commands.wrap.WrapLinesTextCommand;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Unit tests for the WrapLinesTextCommand class.
 *
 * @version 1.0
 * @since 1.0
 * @author Leon Wang
 */
public class WrapLinesTextCommandTest {
    /**
     * Positive test case.
     * Tests wrapping multiple lines of text.
     */
    @Test
    void testWrapMultipleLines() {
        WrapLinesTextCommand command = new WrapLinesTextCommand("<p>", "</p>");
        String input = "first line\nsecond line";
        String expected = "<p>first line</p>\n<p>second line</p>";
        assertEquals(expected, command.execute(input));
    }

    /**
     * Positive test case.
     * Tests wrapping a single line of text.
     */
    @Test
    void testWrapSingleLine() {
        WrapLinesTextCommand command = new WrapLinesTextCommand("[", "]");
        String input = "single line";
        String expected = "[single line]";
        assertEquals(expected, command.execute(input));
    }

    /**
     * Positive test case.
     * Tests wrapping an empty string.
     */
    @Test
    void testWrapEmptyString() {
        WrapLinesTextCommand command = new WrapLinesTextCommand("{", "}");
        String input = "";
        String expected = "{}"; // Wrap av tom streng
        assertEquals(expected, command.execute(input));
    }

    /**
     * Positive test case.
     * Tests wrapping lines with an empty line in between.
     */
    @Test
    void testWrapLinesWithEmptyLine() {
        WrapLinesTextCommand command = new WrapLinesTextCommand("<", ">");
        String input = "line1\n\nline3";
        String expected = "<line1>\n<>\n<line3>";
        assertEquals(expected, command.execute(input));
    }

    /**
     * Negative test case.
     * Tests that passing null input throws an IllegalArgumentException.
     */
    @Test
    void testNullInputThrowsException() {
        WrapLinesTextCommand command = new WrapLinesTextCommand("<", ">");
        assertThrows(IllegalArgumentException.class, () -> command.execute(null));
    }
}
