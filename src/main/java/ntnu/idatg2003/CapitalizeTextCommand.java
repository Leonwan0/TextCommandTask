package ntnu.idatg2003;

/**
 * A command that capitalizes all characters in the given text.
 * This class implements the TextCommand interface and provides an implementation
 * of the execute method to convert the input text to uppercase.
 *
 * @version 1.0
 * @since 1.0
 * @author Leon Wang
 */
public class CapitalizeTextCommand implements TextCommand {
    /**
     * Executes the command to capitalize all characters in the given text.
     *
     * @param text The input text to be capitalized. Must not be null.
     * @return The capitalized version of the input text.
     * @throws IllegalArgumentException if the input text is null.
     */
    @Override
    public String execute(String text) {
        if (text == null) {
            throw new IllegalArgumentException("Text cannot be null");
        }
        return text.toUpperCase();
    }

}
