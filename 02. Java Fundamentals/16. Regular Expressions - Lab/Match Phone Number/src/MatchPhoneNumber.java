import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class MatchPhoneNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String phone=scanner.nextLine();
        String regex = "\\+359([ -])2\\1\\d{3}\\1\\d{4}\\b";

        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(phone);

        List<String> matcherPhone = new ArrayList<>();

        while (matcher.find()){
            matcherPhone.add(matcher.group());
        }
        System.out.println(matcherPhone.toString().replaceAll("[\\]\\[]", ""));

    }
}
