package ntnu.idatg2003;



public class Main {
    public static void main(String[] args) {
        TextCommand command1 = new ReplaceTextCommand("target", "replacement");

        TextCommand command2 = new ReplaceFirstTextCommand("target", "replacement");

        WrapSelectionTextCommand wrapSelectionCommand = new WrapSelectionTextCommand("selection", "<b>", "</b>");
        System.out.println(wrapSelectionCommand.execute("This is a sample text with a selection to be wrapped."));

        WrapLinesTextCommand wrapLinesCommand = new WrapLinesTextCommand("<p>", "</p>");
        System.out.println(wrapLinesCommand.execute("first line\nsecond line"));



        System.out.println(command1.execute("This is the target text with multiple target occurrences of the target word."));

        System.out.println(command2.execute("This is the target text with multiple target occurrences of the target word."));

        CapitalizeTextCommand capitalizeTextCommand = new CapitalizeTextCommand();
        System.out.println(capitalizeTextCommand.execute("this is a sample text."));
    }

}
