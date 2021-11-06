import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem2Other {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Pattern pattern = Pattern.compile("!(?<command>[A-Z][a-z]{2,})!:\\[(?<message>[A-Za-z]{8,})]");
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String message = matcher.group("message");
                StringBuilder a = new StringBuilder();
                for (int j = 0; j < message.length(); j++) {
                    int digit = message.charAt(j);
                    a.append(digit).append(" ");
                }
                System.out.println(matcher.group("command") + ": " + a.toString());
            } else {
                System.out.println("The message is invalid");
            }
        }
    }
}
