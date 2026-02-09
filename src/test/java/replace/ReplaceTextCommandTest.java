package replace;

import commands.replace.ReplaceTextCommand;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


/**
 * Unit tests for the ReplaceTextCommand class.
 * Tests the functionality of replacing all occurrences
 * of a target substring with a replacement substring in a given text.
 *
 * @version 1.0
 * @since 1.0
 * @author Leon Wang
 */
 class ReplaceTextCommandTest {
    @Test

    /**
     * positive test case: verifies that
     * all occurrences of the target substring are replaced with the replacement substring
     * in the input text.
     * Given a ReplaceTextCommand with target "target" and replacement "replacement",
     * when execute is called with the text "text with target and target",
     */
    void execute_replacesAllOccurrencesOfTarget() {
        ReplaceTextCommand command =
                new ReplaceTextCommand("target", "replacement"); // Arrange

        String result = command.execute("text with target and target"); // Act

        assertEquals("text with replacement and replacement", result); // Assert
    }

    /**
     * negative test case: verifies that if the target substring is not found in the input text,
     * the original text is returned unchanged.
      * Given a ReplaceTextCommand with target "missing" and replacement "replacement",
     * when execute is called with the text "text without the word",
     * then the result should be "text without the word" since the target substring "missing" is not found in the input text.
     */
    @Test
    void execute_returnsOriginalTextWhenTargetNotFound() {
        ReplaceTextCommand command =
                new ReplaceTextCommand("missing", "replacement");

        String result = command.execute("text without the word");

        assertEquals("text without the word", result);
    }

    /**
     * negative test case: verifies that if the input text is an empty string, an empty string is returned.
      * Given a ReplaceTextCommand with target "a" and replacement "b",
     * when execute is called with an empty string,
     * then the result should be an empty string since there are no occurrences
     * of the target substring to replace in the input text.
     */
    @Test
    void execute_handlesEmptyInputString() {
        ReplaceTextCommand command =
                new ReplaceTextCommand("a", "b");

        String result = command.execute("");

        assertEquals("", result);
    }

    /**
     * negative test case: verifies that if the input text is null, an IllegalArgumentException is thrown.
      * Given a ReplaceTextCommand with target "a" and replacement "b",
     * when execute is called with null,
     * then an IllegalArgumentException should be thrown since the input text cannot be null.
     */
    @Test
    void execute_throwsExceptionWhenTextIsNull() {
        ReplaceTextCommand command =
                new ReplaceTextCommand("a", "b");

        assertThrows(IllegalArgumentException.class,
                () -> command.execute(null));
    }

    /**
     * positive test case: verifies that the getters return the values passed to the constructor.
      * Given a ReplaceTextCommand with target "target" and replacement "replacement",
     * when getTarget and getReplacement are called,
     * then getTarget should return "target" and getReplacement should return "replacement".
     */
    @Test
    void getters_returnValuesPassedToConstructor() {
        ReplaceTextCommand command =
                new ReplaceTextCommand("target", "replacement");

        assertEquals("target", command.getTarget());
        assertEquals("replacement", command.getReplacement());
    }
}
