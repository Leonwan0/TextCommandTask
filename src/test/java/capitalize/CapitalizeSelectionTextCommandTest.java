package capitalize;

import commands.capitalize.CapitalizeSelectionTextCommand;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Test class for CapitalizeSelectionTextCommand.
 *
 * @version 1.0
 * @since 1.0
 * @author Leon Wang
 */
public class CapitalizeSelectionTextCommandTest {
    /**
     * Negative test case.
     * Tests that the constructor throws an IllegalArgumentException when the selection is null.
     */
    @Test
    void constructor_shouldThrowException_whenSelectionIsNull() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new CapitalizeSelectionTextCommand(null)
        );
        assertEquals("Selection cannot be null", exception.getMessage());
    }

    /**
     * Positive test case.
     * Tests that getSelection returns the correct selection.
     */
    @Test
    void getSelection_shouldReturnCorrectSelection() {
        CapitalizeSelectionTextCommand command = new CapitalizeSelectionTextCommand("word");
        assertEquals("word", command.getSelection());
    }

    /**
     * Positive test case.
     * Tests that execute capitalizes the selected word in the text.
     */
    @Test
    void execute_shouldCapitalizeSelectionInText() {
        CapitalizeSelectionTextCommand command = new CapitalizeSelectionTextCommand("word");
        String result = command.execute("this is a word in a sentence");
        assertEquals("this is a Word in a sentence", result);
    }

    /**
     * Positive test case.
     * Tests that execute capitalizes multiple occurrences of the selected word in the text.
     */
    @Test
    void execute_shouldCapitalizeMultipleOccurrences() {
        CapitalizeSelectionTextCommand command = new CapitalizeSelectionTextCommand("repeat");
        String result = command.execute("repeat this and repeat again");
        assertEquals("Repeat this and Repeat again", result);
    }

    /**
     * Negative test case.
     * Tests that execute throws an IllegalArgumentException when the input text is null.
     */
    @Test
    void execute_shouldThrowException_whenInputTextIsNull() {
        CapitalizeSelectionTextCommand command = new CapitalizeSelectionTextCommand("text");
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> command.execute(null)
        );
        assertEquals("Input text cannot be null", exception.getMessage());
    }

    /**
     * Positive test case.
     * Tests that execute does not change the text if the selection is not found.
     */
    @Test
    void execute_shouldNotChangeTextIfSelectionNotFound() {
        CapitalizeSelectionTextCommand command = new CapitalizeSelectionTextCommand("missing");
        String result = command.execute("no matching text here");
        assertEquals("no matching text here", result);
    }

}
