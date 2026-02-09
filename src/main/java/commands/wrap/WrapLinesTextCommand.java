package commands.wrap;

/**
 * A command that wraps each line of the given text with specified opening and ending strings.
 * Extends the WrapTextCommand class.
 *
 * @version 1.0
 * @since 1.0
 * @author Leon Wang
 */
public class WrapLinesTextCommand extends WrapTextCommand {

    /**
     * Constructs a WrapLinesTextCommand with the specified opening and ending strings.
     * @param opening the opening string
     * @param end the ending string
     */
    public WrapLinesTextCommand(String opening, String end) {
        super(opening, end);
    }

    /**
     * Wraps each line of the given text with the opening and ending strings.
     *
     * @param text the input text
     * @return the wrapped text with each line wrapped individually
     * @throws IllegalArgumentException if the input text is null
     */
    public String execute(String text) {
        if (text == null ) {
            throw new IllegalArgumentException("Text cannot be null");
        }
        String[] lines = text.split("\n", -1); // Split the text into lines, including empty lines
        StringBuilder wrappedText = new StringBuilder();

        // Wrap each line individually
        for (int i = 0; i < lines.length; i++) { // Iterate through each line
            wrappedText.append(super.execute(lines[i])); // Wrap the current line using the parent class's execute method
            if (i < lines.length - 1) { // Add a newline character after each wrapped line except the last one
                wrappedText.append("\n");
            }
        }
        return wrappedText.toString(); // Return the final wrapped text
    }

}
