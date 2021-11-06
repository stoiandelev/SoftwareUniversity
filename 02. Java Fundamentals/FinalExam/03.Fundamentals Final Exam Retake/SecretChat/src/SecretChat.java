import java.util.Scanner;
import java.util.regex.Pattern;

public class SecretChat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        String command = scanner.nextLine();
        while (!command.equals("Reveal")) {
            String[] spitedCommand = command.split(":\\|:");
            String switchCommand = spitedCommand[0];
            switch (switchCommand) {
                case "InsertSpace":
                    int indexSpace = Integer.parseInt(spitedCommand[1]);
                    text = text.substring(0, indexSpace) + " " + text.substring(indexSpace, text.length());
                    System.out.println(text);
                    break;
                case "Reverse":
                    String forCheck = spitedCommand[1];
                    if (text.contains(forCheck)) {
                        String forReplays = new StringBuilder(forCheck).reverse().toString();
                        text = text.replaceFirst(Pattern.quote(forCheck), "") + forReplays;
                        System.out.println(text);
                    }else{
                        System.out.println("error");
                    }
                    break;
                case "ChangeAll":
                    String substringToReplace = spitedCommand[1];
                    String replacement = spitedCommand[2];
                    text = text.replace(substringToReplace, replacement);
                    System.out.println(text);
                    break;
            }


            command = scanner.nextLine();
        }
        System.out.printf("You have a new text message: %s", text);
    }
}
