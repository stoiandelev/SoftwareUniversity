import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String regex = "[@#]+(?<color>[a-z]{3,})[@#]+[^A-Za-z0-9]+[\\/]+(?<amount>\\d+)[\\/]+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            String eggsColor = matcher.group("color");
            int amount = Integer.parseInt(matcher.group("amount"));

            System.out.printf("You found %d %s eggs!%n", amount, eggsColor);

        }
    }
}

