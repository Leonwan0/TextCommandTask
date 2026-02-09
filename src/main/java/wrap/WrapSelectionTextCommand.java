package wrap;

/**
 * A command that wraps the selected text with specified opening and ending strings.
 * This class is used to represent a command that operates on a selected portion of text.
 *
 * @version 1.0
 * @since 1.0
 * @author Leon Wang
 */
public class WrapSelectionTextCommand extends WrapTextCommand {
    private final String selection;

    /**
     * Constructs a WrapSelectionTextCommand with the specified selection.
     * @param selection the selected text to be wrapped
     * @throws IllegalArgumentException if selection is null
     */
    public WrapSelectionTextCommand(String selection, String opening, String end) {
        super(opening, end);
        if (selection == null) {
            throw new IllegalArgumentException("Selection cannot be null");
        }
        this.selection = selection;
    }

    /**
     * Gets the selected text.
     * @return the selected text
     */
    public String getSelection() {
        return selection;
    }

    /**
     * Executes a command that wraps a selected portion of the given text.
     *
     * @param text the input text to be processed (not used in this implementation)
     * @return the result of wrapping the selected text with the specified opening and ending strings
     */
    public String execute(String text) {
        return super.execute(selection); // Wrap the selected text using the parent class's execute method
    }
}
