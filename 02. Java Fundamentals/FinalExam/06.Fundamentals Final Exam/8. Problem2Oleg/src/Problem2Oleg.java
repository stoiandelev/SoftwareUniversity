import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem2Oleg {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        String regex = "(U\\$)(?<username>[A-Z][a-z]{2,})\\1(P@\\$)(?<password>[A-Za-z]{5,}\\d+)\\3";
        int counter = 0;

        for (int i = 0; i < n; i++) {
            String input = scan.nextLine();
            Matcher matcher = Pattern.compile(regex).matcher(input);

            if (matcher.find()) {
                System.out.println("Registration was successful");
                System.out.printf("Username: %s, Password: %s%n", matcher.group("username"), matcher.group("password"));
                counter++;
            } else {
                System.out.println("Invalid username or password");
            }
        }
        System.out.printf("Successful registrations: %d", counter);

    }
}