import java.util.Scanner;

public class ValidUsernamesv1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        String[] usernames = text.split(", ");

        for (String username : usernames) {
            if (isValidUserName(username)) {
                System.out.println(username);
            }

        }


    }

    static boolean isValidUserName(String username) {
        if (username.length() < 3 || username.length() > 16) {
            return false;
        }

        for (int index = 0; index <= username.length() - 1; index++) {
            char currentIndex = username.charAt(index);
            if (!Character.isLetterOrDigit(currentIndex) && currentIndex != '-' && currentIndex != '_') {
                return false;
            }

        }
        return true;
    }
}


