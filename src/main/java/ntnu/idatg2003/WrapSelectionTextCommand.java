package ntnu.idatg2003;

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
     * Wraps the selected text with the specified opening and ending strings.
     * @param opening the opening string to wrap around the selection
     * @param end the ending string to wrap around the selection
     * @return the wrapped selection with the opening and ending strings
      * @throws IllegalArgumentException if opening or end is null
     */
    public String execute(String opening, String end) {
        return opening + selection + end;
    }
}
