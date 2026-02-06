package ntnu.idatg2003;



public class Main {
    public static void main(String[] args) {
        TextCommand command1 = new ReplaceTextCommand("target", "replacement");

        TextCommand command2 = new ReplaceFirstTextCommand("target", "replacement");

        WrapSelectionTextCommand wrapSelectionCommand = new WrapSelectionTextCommand("selected text",
                "<b>", "</b>");
        System.out.println(wrapSelectionCommand.execute("<b>", "</b>"));

        WrapLinesTextCommand wrapLinesTextCommand = new WrapLinesTextCommand("<b>", "</b>");
        System.out.println(wrapLinesTextCommand.execute("Line 1\nLine 2\nLine 3"));

        System.out.println(command1.execute("This is the target text with multiple target occurrences of the target word."));

        System.out.println(command2.execute("This is the target text with multiple target occurrences of the target word."));
    }

}
