import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        //String regex = "^(\\$|%)()(?<tag>[A-Z][a-z]{2,})\\1: (\\[)(?<first>\\d+)(\\])(\\|)\\4(?<second>\\d+)\\6\\7\\4(?<third>\\d+)\\6\\7$";
        //String regexStoian="^([$%])(?<tag>[A-Z][a-z]{2,})\\1: \\[(?<first>\\d+)\\]\\|\\[(?<second>\\d+)\\]\\|\\[(?<third>\\d+)\\]\\|$";
        //String regexStoian="([$%])(?<tag>[A-Z][a-z]{2,})\\1: \\[(?<first>[0-9]+)\\]\\|\\[(?<second>[0-9]+)\\]\\|\\[(?<third>[0-9]+)\\]\\|$";
        String regexStoian="^([$%])(?<tag>[A-Z][a-z]{2,})\\1: \\[(?<first>\\d+)\\]\\|\\[(?<second>\\d+)\\]\\|\\[(?<third>\\d+)\\]\\|$";

        Pattern pattern = Pattern.compile(regexStoian);


        for (int i = 0; i < n; i++) {
            String text = scanner.nextLine();

            Matcher matcher = pattern.matcher(text);

            if (matcher.find()) {
                String tag=matcher.group("tag");
                
                char firstNumber =(char) Integer.parseInt(matcher.group("first"));
                char secondNumber =(char) Integer.parseInt(matcher.group("second"));
                char thirdNumber =(char) Integer.parseInt(matcher.group("third"));

                System.out.printf("%s: %s%s%s%n",tag,firstNumber,secondNumber,thirdNumber);
            }else{
                System.out.println("Valid message not found!");
            }

        }
    }
}

