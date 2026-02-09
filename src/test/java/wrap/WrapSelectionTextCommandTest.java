package wrap;

import commands.wrap.WrapSelectionTextCommand;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Unit tests for the WrapSelectionTextCommand class.
 * This class tests the functionality of the WrapSelectionTextCommand,
 * ensuring that it correctly wraps the selected text according to specified parameters.
 *
 * @version 1.0
 * @since 1.0
 * @author Leon Wang
 */
public class WrapSelectionTextCommandTest {
    @Test
    void testExecute_WrapsSelectionCorrectly() {
        WrapSelectionTextCommand command = new WrapSelectionTextCommand("selection", "<p>", "</p>");
        String result = command.execute("some text with selection inside");
        assertEquals("<p>selection</p>", result, "The selected text should be wrapped correctly");
    }

    /**
     * Positive test case for the getSelection method of the WrapSelectionTextCommand class.
      * Tests that the getSelection method
     * returns the correct selected text that was initialized in the constructor.
     */
    @Test
    void testGetSelection_ReturnsSelection() {
        WrapSelectionTextCommand command = new WrapSelectionTextCommand("myText", "<b>", "</b>");
        assertEquals("myText", command.getSelection(), "getSelection should return the correct text");
    }

    /**
     * Negative test case for the constructor of the WrapSelectionTextCommand class.
     * Tests that the constructor throws an IllegalArgumentException when the selection is null.
     */
    @Test
    void testConstructor_NullSelection_ThrowsException() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new WrapSelectionTextCommand(null, "<p>", "</p>"),
                "Constructor should throw IllegalArgumentException if selection is null"
        );
        assertEquals("Selection cannot be null", exception.getMessage());
    }

    /**
     * Positive test case for the execute method of the WrapSelectionTextCommand class with an empty selection.
     * Tests that the execute method correctly wraps an empty string when the selection is empty,
     * resulting in just the opening and ending strings being concatenated.
     */
    @Test
    void testExecute_WithEmptySelection_WrapsEmptyString() {
        WrapSelectionTextCommand command = new WrapSelectionTextCommand("", "[", "]");
        String result = command.execute("any text");
        assertEquals("[]", result, "Even empty selection should be wrapped correctly");
    }

    /**
     * Positive test case for the execute method of the WrapSelectionTextCommand class with special characters in the selection.
     * Tests that the execute method correctly wraps a selection that contains special characters,
     * ensuring that the special characters are preserved in the output.
     */
    @Test
    void testExecute_WithSpecialCharacters() {
        WrapSelectionTextCommand command = new WrapSelectionTextCommand("hello\nworld", "<div>", "</div>");
        String result = command.execute("any text");
        assertEquals("<div>hello\nworld</div>", result, "Should correctly wrap selection containing special characters");
    }
}
