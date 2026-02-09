package capitalize;

import commands.capitalize.CapitalizeTextCommand;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Unit test class for CapitalizeTextCommand.
 *
 * @version 1.0
 * @since 1.0
 * @author Leon Wang
 */
 class CapitalizeTextCommandTest {
    private final CapitalizeTextCommand command = new CapitalizeTextCommand();

    /**
     * Positive test cases for CapitalizeTextCommand.
     * A test to verify that the command correctly capitalizes
     * the first initial of the first word in various input scenarios.
     */
    @Test
    void testCapitalizeNormalText() {
        String input = "hello world";
        String expected = "Hello world";
        assertEquals(expected, command.execute(input));
    }

    /**
     * Positive test case for empty string input.
     * Verifies that the command returns an empty string
     * when given an empty string as input.
     */
    @Test
    void testCapitalizeEmptyString() {
        String input = "";
        String expected = "";
        assertEquals(expected, command.execute(input));
    }

    /**
     * Positive test case for single character input.
     * Verifies that the command correctly capitalizes
     * a single lowercase character.
     */
    @Test
    void testCapitalizeAlreadyCapitalized() {
        String input = "Hello world";
        String expected = "Hello world";
        assertEquals(expected, command.execute(input));
    }

    /**
     * Positive test case for input starting with a number.
     * Verifies that the command leaves the input unchanged
     * when the first character is a number.
     */
    @Test
    void testCapitalizeStartsWithNumber() {
        String input = "123abc";
        String expected = "123abc";
        assertEquals(expected, command.execute(input));
    }

    /**
     * Positive test case for input starting with a symbol.
     * Verifies that the command leaves the input unchanged
     * when the first character is a symbol.
     */
    @Test
    void testCapitalizeStartsWithSymbol() {
        String input = "#hashtag";
        String expected = "#hashtag";
        assertEquals(expected, command.execute(input));
    }

    /**
     * Negative test case for null input.
     * Verifies that the command throws an IllegalArgumentException
     * when given a null input.
     */
    @Test
    void testNullInputThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> command.execute(null));
    }
}
