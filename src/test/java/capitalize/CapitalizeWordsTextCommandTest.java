package capitalize;

import commands.capitalize.CapitalizeWordsTextCommand;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Test class for CapitalizeWordsTextCommand.
 *
 * @version 1.0
 * @since 1.0
 * @author Leon Wang
 */
 class CapitalizeWordsTextCommandTest {
    @Test
    /**
     * Positive test case.
     * Tests that the execute method correctly capitalizes the first letter
     * of each word in the input text.
     */
    void execute_shouldCapitalizeFirstLetterOfEachWord() {
        CapitalizeWordsTextCommand command = new CapitalizeWordsTextCommand();
        String result = command.execute("hello world");
        assertEquals("Hello World", result);
    }

    @Test
    /**
     * Negative test case.
     * Tests that the execute method returns an empty string
     * when given an empty string as input.
     */
    void testNullInputThrowsException() {
        CapitalizeWordsTextCommand command = new CapitalizeWordsTextCommand();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            command.execute(null);
        });
        assertEquals("Input text cannot be null", exception.getMessage());
    }

}
