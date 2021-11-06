import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem1ValidationFinalRetake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String password = scanner.nextLine();
        String input = scanner.nextLine();


        while (!input.equals("Complete")) {

            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "Make":
                    String letterCase = tokens[1];
                    int indexToChange = Integer.parseInt(tokens[2]);

                    if (letterCase.equals("Upper")) {

                        char letterToChange = password.charAt(indexToChange);
                        char newLetter = Character.toUpperCase(letterToChange);

                        if (Character.isAlphabetic(letterToChange)) {
                            StringBuilder newPassword = new StringBuilder(password);
                            newPassword.setCharAt(indexToChange, newLetter);

                            System.out.println(newPassword);
                            password = newPassword.toString();

                        }
                    } else if (letterCase.equals("Lower")) {
                        char letterToChange = password.charAt(indexToChange);
                        char newLetter = Character.toLowerCase(letterToChange);

                        if (Character.isAlphabetic(letterToChange)) {
                            StringBuilder newPassword = new StringBuilder(password);
                            newPassword.setCharAt(indexToChange, newLetter);

                            System.out.println(newPassword.toString());
                            password = newPassword.toString();
                        }

                    }
                    break;
                case "Insert":
                    int indexToInsert = Integer.parseInt(tokens[1]);
                    String symbolToInsert = tokens[2];

                    StringBuilder newPassword = new StringBuilder(password);
                    newPassword.insert(indexToInsert,symbolToInsert);

                    System.out.println(newPassword.toString());
                    password = newPassword.toString();
                    break;
                case "Replace":
                    String symbolToReplace = tokens[1];
                    int valueToAdd = Integer.parseInt(tokens[2]);

                    if (password.contains(symbolToReplace)) {
                        char symbol = symbolToReplace.charAt(0);
                        char newSymbol = (char) (symbol + valueToAdd);
                        //replace all accuracy
                        password = password.replace(symbol, newSymbol);
                        System.out.println(password);
                    }

                    break;
                case "Validation":

                    if (password.length() < 8) {

                        System.out.println("Password must be at least 8 characters long!");
                    }
                    String regexInvalidSymbols = "\\W";

                    Pattern pattern = Pattern.compile(regexInvalidSymbols);
                    Matcher matcher = pattern.matcher(password);

                    if (matcher.find()) {
                        System.out.println("Password must consist only of letters, digits and _!");
                    }
                    String regexUppercaseLetter = "[A-Z]+";

                    pattern = Pattern.compile(regexUppercaseLetter);
                    matcher = pattern.matcher(password);

                    if (!matcher.find()) {
                        System.out.println("Password must consist at least one uppercase letter!");
                    }
                    String regexLowercaseLetter = "[a-z]+";

                    pattern = Pattern.compile(regexLowercaseLetter);
                    matcher = pattern.matcher(password);

                    if (!matcher.find()) {
                        System.out.println("Password must consist at least one lowercase letter!");
                    }

                    String regexDigit = "[0-9]+";

                    pattern = Pattern.compile(regexDigit);
                    matcher = pattern.matcher(password);

                    if (!matcher.find()) {
                        System.out.println("Password must consist at least one digit!");
                    }
                    break;

            }

            input = scanner.nextLine();
        }


    }
}
