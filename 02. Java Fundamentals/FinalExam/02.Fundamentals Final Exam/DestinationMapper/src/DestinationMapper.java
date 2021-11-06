import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DestinationMapper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        String validRegex = "([=\\/])([A-Z][A-Za-z]{2,})\\1";

        Pattern pattern = Pattern.compile(validRegex);
        Matcher matcher = pattern.matcher(text);

        List<String> validDestination = new ArrayList<>();
        while (matcher.find()) {
            validDestination.add(matcher.group(2));

        }
        int travelPoints = 0;
        for (String validCity : validDestination) {

            for (int i = 0; i < validCity.length(); i++) {
                travelPoints++;
            }



        }
        System.out.println("Destinations: " + String.join(", ", validDestination));
        System.out.println("Travel Points: " + travelPoints);


    }
}