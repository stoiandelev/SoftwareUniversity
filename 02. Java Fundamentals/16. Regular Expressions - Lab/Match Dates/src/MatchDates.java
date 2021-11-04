import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchDates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String days = scanner.nextLine();
        String regex = "\\b(?<day>\\d{2})([\\.\\-\\/])(?<mount>[A-Z][a-z]{2})\\2(?<year>\\d{4})\\b";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(days);

        while (matcher.find()) {
            String day = matcher.group("day");
            String mount = matcher.group("mount");
            String year = matcher.group("year");

            System.out.printf("Day: %s, Month: %s, Year: %s%n", day, mount, year);
        }


    }
}
