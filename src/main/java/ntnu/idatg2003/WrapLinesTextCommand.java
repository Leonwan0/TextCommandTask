package ntnu.idatg2003;

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

}
