package replace;

import TextCommand;

/**
 * A command that replaces all occurrences of a target substring with a replacement substring in the given text.
 * Implements the TextCommand interface.
 *
 * @version 1.0
 * @since 1.0
 * @author Leon Wang
 */
public class ReplaceTextCommand implements TextCommand {
    protected String target;
    protected String replacement;

    /**
     * Constructs a ReplaceTextCommand with the specified target and replacement substrings.
     *
     * @param target the substring to be replaced
     * @param replacement the substring to replace with
     * @throws IllegalArgumentException if target or replacement is null
     */
    public ReplaceTextCommand(String target, String replacement) {
        if (target == null || replacement == null) {
            throw new IllegalArgumentException("Target and replacement cannot be null");
        }
        this.target = target;
        this.replacement = replacement;
    }

    /**
     * Gets the target substring.
     *
     * @return the target substring
     */
    public String getTarget() {
        return target;
    }

    /**
     * Gets the replacement substring.
     *
     * @return the replacement substring
     */
    public String getReplacement() {
        return replacement;
    }

    /**
     * Replaces all occurrences of the target substring with the replacement substring in the given text.
     *
     * @param text the input text
     * @return the modified text with replacements
     * @throws IllegalArgumentException if the input text is null
     */
    @Override
    public String execute(String text) {
        if (text == null ) {
            throw new IllegalArgumentException("Text cannot be null");
        }
        return text.replace(target, replacement);
    }
}
