import java.util.Scanner;

public class PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        while (!command.equals("END")) {

            System.out.println(isPalindrome(command));

            command = scanner.nextLine();
        }
    }

    private static boolean isPalindrome(String numberAsString) {
        StringBuilder builderLeft = new StringBuilder();

        for (int leftToRight = 0; leftToRight < numberAsString.length(); leftToRight++) {
            builderLeft.append(numberAsString.charAt(leftToRight));
        }

        StringBuilder builderRight = new StringBuilder();
        for (int rightToLeft = numberAsString.length() - 1; rightToLeft >= 0; rightToLeft--) {
            builderRight.append(numberAsString.charAt(rightToLeft));
        }
        return builderLeft.toString().equals(builderRight.toString());
    }
}


