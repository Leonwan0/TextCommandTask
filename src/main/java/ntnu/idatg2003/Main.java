package ntnu.idatg2003;


import java.util.List;

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

        CapitalizeWordsTextCommand capitalizeWordsTextCommand = new CapitalizeWordsTextCommand();
        System.out.println(capitalizeWordsTextCommand.execute("text to be capitalized."));

        CapitalizeSelectionTextCommand capitalizeSelectionCommand = new CapitalizeSelectionTextCommand("selection");
        System.out.println(capitalizeSelectionCommand.execute("text with a selection and another selection"));

        List<TextCommand> commands = List.of(
                new ReplaceTextCommand("target", "replacement"),
                new CapitalizeWordsTextCommand(),
                new WrapLinesTextCommand("<p>", "</p>")
        );
        Script script = new Script(commands);
        String result = script.execute("This is the target text with multiple target occurrences of the target word.");
        System.out.println(result);
    }

}
