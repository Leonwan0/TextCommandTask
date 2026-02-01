package ntnu.idatg2003;

public class ReplaceFirstTextCommand extends ReplaceTextCommand {
    /**
     * Constructs a ReplaceFirstTextCommand with the specified target and replacement substrings.
     *
     * @param target the substring to be replaced
     * @param replacement the substring to replace with
     * @throws IllegalArgumentException if target or replacement is null
     */
    public ReplaceFirstTextCommand(String target, String replacement) {
        super(target, replacement);
    }

    /**
     * Replaces the first occurrence of the target substring with the replacement substring in the given text.
     *
     * @param text the input text
     * @return the modified text with the first occurrence replaced
     * @throws IllegalArgumentException if the input text is null
     */
    @Override
    public String execute(String text) {
        if (text == null ) {
            throw new IllegalArgumentException("Text cannot be null");
        }
        return text.replaceFirst(getTarget(), getReplacement());
    }
}
