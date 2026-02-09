package capitalize;

/**
 * A command that capitalizes the first initial of each word in the input text.
 * This class extends the CapitalizeTextCommand and provides an implementation
 * of the execute method to convert the first character of each word in the input text to uppercase,
 * while leaving the rest of the text unchanged.
 *
 * @version 1.1
 * @since 1.0
 * @author Leon Wang
 */
public class CapitalizeWordsTextCommand extends CapitalizeTextCommand {
    @Override
    public String execute(String text) {
        if (text == null) {
            throw new IllegalArgumentException("Input text cannot be null");
        }
        String[] words = text.split("\\s+"); // Split the input text into words using whitespace as a delimiter
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            if (!word.isEmpty()) {
                result.append(super.execute(word)).append(" "); // Capitalize the first character of each word and append to the result
            }
        }
        return result.toString().trim(); // Return the final capitalized string, trimming any trailing whitespace
    }
}