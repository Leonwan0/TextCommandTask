package ntnu.idatg2003;

/**
 * A command that capitalizes the first initial of the first word in the input text.
 * This class implements the TextCommand interface and provides an implementation
 * of the execute method to convert the first character of the first word in the input text to uppercase,
 * while leaving the rest of the text unchanged.
 *
 * @version 1.1
 * @since 1.0
 * @author Leon Wang
 */
public class CapitalizeTextCommand implements TextCommand {
    /**
     * Executes the command to capitalize the first initial of the first word in the input text.
     * The method takes a non-null String as input and returns a new String with the first initial of the first word capitalized.
     * @param text The input text to be capitalized. Must not be null.
     * @return The capitalized version of the input text.
     * @throws IllegalArgumentException if the input text is null.
     */
    @Override
    public String execute(String text) {
        if (text == null) {
            throw new IllegalArgumentException("Input text cannot be null");
        }
        if (text.isEmpty()) {
            return text; // Return empty string if input is empty
        }
        char firstChar = Character.toUpperCase(text.charAt(0)); // recommended by ChatGPT
        return firstChar + text.substring(1); // capitalize the first character and concatenate with the rest of the string
    }


}
