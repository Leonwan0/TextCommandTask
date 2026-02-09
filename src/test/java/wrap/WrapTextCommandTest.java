package wrap;

import commands.wrap.WrapTextCommand;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Unit tests for the WrapTextCommand class.
 * This class tests the functionality of the WrapTextCommand,
 * ensuring that it correctly wraps text according to specified parameters.
 *
 * @version 1.0
 * @since 1.0
 * @author Leon Wang
 */
public class WrapTextCommandTest {

    /**
     * Positive test case for the constructor and getters of the WrapTextCommand class.
     * Tests that the constructor correctly initializes the opening and ending strings,
     * and that the getters return the expected values.
     */
    @Test
    void testConstructorAndGetters() {
        WrapTextCommand command = new WrapTextCommand("<p>", "</p>"); // Arrange
        assertEquals("<p>", command.getOpening()); // Assert
        assertEquals("</p>", command.getEnd()); // Assert
    }

    /**
     * Negative test case for the constructor of the WrapTextCommand class.
     * Tests that the constructor
     * throws an IllegalArgumentException when the opening string is null.
     */
    @Test
    void testConstructorWithNullOpening() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new WrapTextCommand(null, "</p>");
        });
        assertEquals("Opening and end cannot be null", exception.getMessage());
    }

    /**
     * Negative test case for the constructor of the WrapTextCommand class.
     * Tests that the constructor
     * throws an IllegalArgumentException when the ending string is null.
     */
    @Test
    void testConstructorWithNullEnd() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new WrapTextCommand("<p>", null);
        });
        assertEquals("Opening and end cannot be null", exception.getMessage());
    }

    /**
     * Positive test case for the execute method of the WrapTextCommand class.
     * Tests that the execute method correctly wraps the input text with the specified opening and ending strings
     */
    @Test
    void testExecuteWrapsTextCorrectly() {
        WrapTextCommand command = new WrapTextCommand("[", "]");
        String result = command.execute("text");
        assertEquals("[text]", result);
    }

    /**
     * Negative test case for the execute method of the WrapTextCommand class.
     * Tests that the execute method throws an IllegalArgumentException when the input text is null.
     */
    @Test
    void testExecuteWithEmptyText() {
        WrapTextCommand command = new WrapTextCommand("{", "}");
        String result = command.execute("");
        assertEquals("{}", result);
    }

    /**
     * Negative test case for the execute method of the WrapTextCommand class.
     * Tests that the execute method throws an IllegalArgumentException when the input text is null.
     */
    @Test
    void testExecuteWithNullText() {
        WrapTextCommand command = new WrapTextCommand("(", ")");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            command.execute(null);
        });
        assertEquals("Text cannot be null", exception.getMessage());
    }
}

