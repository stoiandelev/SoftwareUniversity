import java.util.Scanner;
import java.util.regex.Pattern;

public class Problem1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        StringBuilder password = new StringBuilder(scan.nextLine());

        String input = scan.nextLine();
        while (!input.equals("Complete")) {
            String [] command = input.split(" ");
            String commandOne = command[0];

            switch (commandOne) {
                case "Make":
                    int upperOrLower = Integer.parseInt(command[2]);
                    char pass = password.charAt(upperOrLower);
                    if (command[1].equals("Upper")) {
                        password.setCharAt(upperOrLower, Character.toUpperCase(pass));
                    } else if (command[1].equals("Lower")) {
                        password.setCharAt(upperOrLower, Character.toLowerCase(pass));
                    }
                    System.out.println(password);
                    break;
                case "Insert":
                    password.insert(Integer.parseInt(command[1]), command[2]);
                    System.out.println(password);
                    break;
                case "Replace":
                    char findChar = command[1].charAt(0); // first char
                    int find = (int) findChar;
                    int charValue = find + Integer.parseInt(command[2]);
                    char character = (char) charValue;
                    String tempPass = password.toString().replace(findChar, character);

                    password.delete(0, password.length());
                    password.append(tempPass);
                    System.out.println(password);
                    break;
                case "Validation":
                    int isUpper = 0;
                    int isLower = 0;
                    for (int i = 0; i < password.length(); i++) {
                        char ch = password.charAt(i);
                        if (Character.isUpperCase(ch)) {
                            isUpper++;
                        }
                        if (Character.isLowerCase(ch)) {
                            isLower++;
                        }
                    }
                    String regex = "(.)*(\\d)(.)*";
                    Pattern pattern = Pattern.compile(regex);

                    String regexTwo = "[a-zA-Z\\w\\_\\d]+";
                    Pattern patternTwo = Pattern.compile(regexTwo);
                    int length = password.length();
                    if (password.length() < 8) {
                        System.out.println("Password must be at least 8 characters long!");
                    }
                    if (!patternTwo.matcher(password).matches()) {
                        System.out.println("Password must consist only of letters, digits and _!");
                    }
                    if (isUpper < 1) {
                        System.out.println("Password must consist at least one uppercase letter!");
                    }
                    if (isLower < 1) {
                        System.out.println("Password must consist at least one lowercase letter!");
                    }
                    if (!pattern.matcher(password).matches()) {
                        System.out.println("Password must consist at least one digit!");
                    }
                    break;
                default:

            }

            input = scan.nextLine();
        }

    }

}