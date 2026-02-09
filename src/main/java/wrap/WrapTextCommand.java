package wrap;

import TextCommand;

/**
 * A command that wraps the given text with specified opening and ending strings.
 * Implements the TextCommand interface.
 *
 * @version 1.0
 * @since 1.0
 * @author Leon Wang
 */
public class WrapTextCommand implements TextCommand {
    protected String opening;
    protected String end;

    /**
     * Constructs a WrapTextCommand with the specified opening and ending strings.
     *
     * @param opening the opening string
     * @param end the ending string
     * @throws IllegalArgumentException if opening or end is null
     */
    public WrapTextCommand(String opening, String end) {
        if (opening == null || end == null) {
            throw new IllegalArgumentException("Opening and end cannot be null");
        }
        this.opening = opening;
        this.end = end;
    }

    /**
     * Gets the opening string.
     * @return the opening string
     */
    public String getOpening() {
        return opening;
    }

    /**
     * Gets the ending string.
     * @return the ending string
     */
    public String getEnd() {
        return end;
    }

    /**
     * Wraps the given text with the opening and ending strings.
     *
     * @param text the input text
     * @return the wrapped text
     * @throws IllegalArgumentException if the input text is null
     */
    public String execute(String text) {
        if (text == null || opening == null || end == null) {
            throw new IllegalArgumentException("Text cannot be null");
        }
        return opening + text + end;
    }

}
