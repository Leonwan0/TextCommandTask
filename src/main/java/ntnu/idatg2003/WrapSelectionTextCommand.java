package ntnu.idatg2003;

/**
 * A command that wraps the selected text with specified opening and ending strings.
 * This class is used to represent a command that operates on a selected portion of text.
 *
 * @version 1.0
 * @since 1.0
 * @author Leon Wang
 */
public class WrapSelectionTextCommand {
    private final String selection;

    /**
     * Constructs a WrapSelectionTextCommand with the specified selection.
     * @param selection the selected text to be wrapped
     * @throws IllegalArgumentException if selection is null
     */
    public WrapSelectionTextCommand(String selection) {
        if (selection == null) {
            throw new IllegalArgumentException("Selection cannot be null");
        }
        this.selection = selection;
    }
}
