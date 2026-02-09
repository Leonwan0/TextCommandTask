package commands.script;

import commands.TextCommand;

import java.util.List;

/**
 * The Script class represents a sequence of TextCommand objects
 * that can be executed in order to transform an input text.
 * Each TextCommand in the script is executed sequentially,
 * with the output of one command serving as the input for the next command.
 *
 * @version 1.1
 * @since 1.0
 * @author Leon Wang
 */
public class Script {
    private final List<TextCommand> textCommands; // A list to hold the commands.capitalize.TextCommand objects that make up the script

    /**
     * Creates a script with the given list of commands.capitalize.TextCommand objects.
     * @param textCommands the list of commands.capitalize.TextCommand objects to be included in the script. Must not be null.
     */
    public Script(List<TextCommand> textCommands) {
        if (textCommands == null) {
            throw new IllegalArgumentException("Text commands list cannot be null");
        }
        this.textCommands = textCommands; // Initialize the textCommands field with the provided list of commands.capitalize.TextCommand objects
    }

    /**
     * Execute all commands in the script in sequence,
     * passing the result of each command as input to the next.
     * @param Text the initial input text to be processed by the script. Must not be null.
     * @return the final output text after all commands have been executed.
     * @throws IllegalArgumentException if the input text is null.
     */
    public String execute(String Text) {
        if (Text == null) {
            throw new IllegalArgumentException("Text cannot be null");
        }
        String result = Text;
        for (TextCommand command : textCommands) { // Iterate through each command in the script
            result = command.execute(result);
        }
        return result; // Return the final result after executing all commands
    }

}
