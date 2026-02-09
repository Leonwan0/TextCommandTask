package replace;

import commands.replace.ReplaceFirstTextCommand;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit tests for the ReplaceFirstTextCommand class.
 * Tests the functionality of replacing the first occurrence of a target substring
 * with a replacement substring in a given text.
 *
 * @version 1.0
 * @since 1.0
 * @author Leon Wang
 */
public class ReplaceFirstTextCommandTest {
    /**
     * Positive test case: verifies that the first occurrence of the target substring
     * is replaced with the replacement substring in the input text.
      * Given a ReplaceFirstTextCommand with target "brown" and replacement "red",
     * when execute is called with the text "The quick brown fox jumps over the lazy dog.",
     * then the result should be "The quick red fox jumps over the lazy dog."
     * since the first occurrence of "brown" is replaced with "red".
     */
    @Test
    public void testReplaceFirstOccurrence() {
        String input = "The quick brown fox jumps over the lazy dog.";
        String expected = "The quick red fox jumps over the lazy dog.";
        ReplaceFirstTextCommand command = new ReplaceFirstTextCommand("brown", "red");
        String result = command.execute(input);
        assertEquals(expected, result);
    }

    /**
     * Negative test case: verifies that if the target substring is not found in the input text, the original text is returned unchanged.
      * Given a ReplaceFirstTextCommand with target "cat" and replacement "dog",
     * when execute is called with the text "The quick brown fox jumps over the lazy dog.",
     * then the result should be "The quick brown fox jumps over the lazy dog."
     * since the target substring "cat" is not found in the input text,
     * and therefore no replacement occurs.
     */
    @Test
    public void testReplaceFirstOccurrenceNotFound() {
        String input = "The quick brown fox jumps over the lazy dog.";
        String expected = "The quick brown fox jumps over the lazy dog.";
        ReplaceFirstTextCommand command = new ReplaceFirstTextCommand("cat", "dog");
        String result = command.execute(input);
        assertEquals(expected, result);
    }
}
