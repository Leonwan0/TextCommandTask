package ntnu.idatg2003;

public class WrapTextCommand {
    private final String opening;
    private  final String end;

    public WrapTextCommand(String opening, String end) {
        if (opening == null || end == null) {
            throw new IllegalArgumentException("Opening and end cannot be null");
        }
        this.opening = opening;
        this.end = end;
    }

}
