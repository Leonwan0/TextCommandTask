package replace;

import commands.replace.ReplaceTextCommand;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


/**
 * Unit tests for the ReplaceTextCommand class.
 */
 class ReplaceTextCommandTest {
    @Test
    void execute_replacesAllOccurrencesOfTarget() {
        ReplaceTextCommand command =
                new ReplaceTextCommand("target", "replacement");

        String result = command.execute("text with target and target");

        assertEquals("text with replacement and replacement", result);
    }

    @Test
    void execute_returnsOriginalTextWhenTargetNotFound() {
        ReplaceTextCommand command =
                new ReplaceTextCommand("missing", "replacement");

        String result = command.execute("text without the word");

        assertEquals("text without the word", result);
    }

    @Test
    void execute_handlesEmptyInputString() {
        ReplaceTextCommand command =
                new ReplaceTextCommand("a", "b");

        String result = command.execute("");

        assertEquals("", result);
    }

    @Test
    void execute_throwsExceptionWhenTextIsNull() {
        ReplaceTextCommand command =
                new ReplaceTextCommand("a", "b");

        assertThrows(IllegalArgumentException.class,
                () -> command.execute(null));
    }

    @Test
    void getters_returnValuesPassedToConstructor() {
        ReplaceTextCommand command =
                new ReplaceTextCommand("target", "replacement");

        assertEquals("target", command.getTarget());
        assertEquals("replacement", command.getReplacement());
    }
}
