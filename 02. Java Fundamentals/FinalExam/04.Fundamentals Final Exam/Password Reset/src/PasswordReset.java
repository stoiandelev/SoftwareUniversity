import java.util.Scanner;

public class PasswordReset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String password = scanner.nextLine();
        String command = scanner.nextLine();


        while (!command.equals("Done")) {
            String[] token = command.split("\\s+");
            String commandName = token[0];

            switch (commandName) {
                case "TakeOdd":
                    StringBuilder newPassword = new StringBuilder();
                    for (int index = 1; index < password.length(); index += 2) {
                        char currentIndex = password.charAt(index);
                        newPassword.append(currentIndex);
                    }
                    password = newPassword.toString();
                    System.out.println(password);

                    break;
                case "Cut":
                    int cutIndex = Integer.parseInt(token[1]);
                    int lengthIndex = Integer.parseInt(token[2]);
                    String substringForRemove = password.substring(cutIndex, cutIndex + lengthIndex);
                    password = password.replaceFirst(substringForRemove, "");
                    System.out.println(password);

                    break;
                case "Substitute":
                    String haveSubstring = token[1];
                    String newSubstring = token[2];

                    if (password.contains(haveSubstring)) {
                        password = password.replace(haveSubstring, newSubstring);
                        System.out.println(password);
                    } else {
                        System.out.println("Nothing to replace!");
                    }
                    break;
            }


            command = scanner.nextLine();
        }
        System.out.printf("Your password is: %s", password);


    }
}
