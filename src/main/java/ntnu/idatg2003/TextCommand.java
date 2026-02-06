package ntnu.idatg2003;

/**
 * An interface representing a text command that can be executed on a given text.
 * The execute method takes a String input and returns a modified String output.
 * This interface can be implemented to create various text processing commands.
 *
 * @version 1.0
 * @since 1.0
 * @author Leon Wang
 *
 */
public interface TextCommand {
    String execute(String text);
}
