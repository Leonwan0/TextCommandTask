package commands.capitalize;

/**
 * A command that capitalizes the first initial of the first word in the selected text.
 * This class extends the CapitalizeTextCommand and provides an implementation
 * of the execute method to convert the first character of the first word in the selected text to uppercase,
 * while leaving the rest of the text unchanged.
 *
 * @version 1.0
 * @since 1.0
 * @author Leon Wang
 */
public class CapitalizeSelectionTextCommand extends CapitalizeTextCommand {
    private final String selection;

    /**
     * Constructs a CapitalizeSelectionTextCommand with the specified selection.
     * @param selection the selected text to be capitalized
     * @throws IllegalArgumentException if selection is null
     */
    public CapitalizeSelectionTextCommand(String selection) {
        if (selection == null) {
            throw new IllegalArgumentException("Selection cannot be null");
        }
        this.selection = selection;
    }

    public String getSelection() {
        return selection;
    }

    /**
     * Executes the command to capitalize the first initial of the selected word in the given text.
     * @param text The input text to be capitalized. Must not be null.
     * @return The capitalized version of the selected word within the input text.
     */
    @Override
    public String execute(String text) {
        if  (text == null) {
            throw new IllegalArgumentException("Input text cannot be null");
        }
        return text.replace(selection, super.execute(selection)); // Replace the selected text with its capitalized version
    }
}
