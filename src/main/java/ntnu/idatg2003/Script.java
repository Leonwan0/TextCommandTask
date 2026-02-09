package ntnu.idatg2003;


import java.util.List;

/**
 * The Script class represents a collection of TextCommand objects that can be executed in sequence.
 * It provides a way to store and manage multiple text commands,
 * allowing for the execution of a series of text transformations or manipulations on a given input text.
 * Create multiple commands that we can then run in a series,
 * so that the result from one command becomes the input to the next.
 *
 * @version 1.1
 * @since 1.0
 * @author Leon Wang
 */
public class Script {
    private final List<TextCommand> textCommands;

    /**
     * Creates a script with the given list of TextCommand objects.
     * @param textCommands the list of TextCommand objects to be included in the script. Must not be null.
     */
    public Script(List<TextCommand> textCommands) {
        if (textCommands == null) {
            throw new IllegalArgumentException("Text commands list cannot be null");
        }
        this.textCommands = textCommands;
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
