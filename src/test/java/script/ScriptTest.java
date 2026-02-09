package script;

import commands.TextCommand;
import commands.capitalize.CapitalizeWordsTextCommand;
import commands.replace.ReplaceTextCommand;
import commands.script.Script;
import commands.wrap.WrapLinesTextCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class for Script.
 *
 * @version 1.0
 * @since 1.0
 * @author Leon Wang
 */
 class ScriptTest {
    /**
     * Positive test case for executing a script with multiple commands.
     * This test verifies that the Script class correctly executes a sequence
     * of TextCommand objects and produces the expected output.
     */
    @Test
    void testScriptExecution() {
        List<TextCommand> commands = List.of(
                new ReplaceTextCommand("target", "replacement"),
                new CapitalizeWordsTextCommand(),
                new WrapLinesTextCommand("<p>", "</p>")
        );
        Script script = new Script(commands);
        String result = script.execute("This is the target text with multiple target occurrences of the target word.");
        String expected = "<p>This Is The Replacement Text With Multiple Replacement Occurrences Of The Replacement Word.</p>";
        assertEquals(expected, result);
    }

    /**
     * Positive test case for executing a script with an empty list of commands.
     * This test verifies that the Script class correctly handles the case where no commands are provided,
     * and that the output remains unchanged from the input text.
     */
    @Test
    void testScriptExecutionWithEmptyCommands() {
        List<TextCommand> commands = List.of();
        Script script = new Script(commands);
        String result = script.execute("This is a sample text.");
        String expected = "This is a sample text.";
        assertEquals(expected, result);
    }

    /**
     * Negative test case for executing a script with a null input text.
     * This test verifies that the Script class correctly throws an IllegalArgumentException
     */
    @Test
    void testScriptExecutionWithNullText() {
        List<TextCommand> commands = List.of(
                new ReplaceTextCommand("target", "replacement"),
                new CapitalizeWordsTextCommand(),
                new WrapLinesTextCommand("<p>", "</p>")
        );
        Script script = new Script(commands);
        try {
            script.execute(null);
        } catch (IllegalArgumentException e) {
            assertEquals("Text cannot be null", e.getMessage());
        }
    }
}
