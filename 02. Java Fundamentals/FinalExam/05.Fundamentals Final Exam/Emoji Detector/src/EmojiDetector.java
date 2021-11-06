import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        List<Integer> numbersList = new ArrayList<>();

        String regexNumber = "\\d";
        Pattern patternNumber = Pattern.compile(regexNumber);
        Matcher matcherNumber = patternNumber.matcher(text);

        while (matcherNumber.find()) {
            int number = Integer.parseInt(matcherNumber.group());
            numbersList.add(number);
        }
        long threshold = numbersList.stream().reduce(1, (a, b) -> a * b);
        System.out.printf("Cool threshold: %d%n", threshold);

        String regexEmoji = "(?<saparator>[:\\*])\\1(?<emoji>[A-Z][a-z]{2,})\\1\\1";
        Pattern patternEmoji = Pattern.compile(regexEmoji);
        Matcher matcherEmoji = patternEmoji.matcher(text);

        List<String> emojiList = new ArrayList<>();
        int countOfEmoji = 0;

        while (matcherEmoji.find()) {
            countOfEmoji++;
            String separator = matcherEmoji.group("saparator");
            String emojiText = matcherEmoji.group("emoji");

            //проверка дали емоджите е cool
            int emojiCoolness = 0;
            for (int i = 0; i < emojiText.length(); i++) {
                char emojiCharacter = emojiText.charAt(i);
                emojiCoolness += emojiCharacter;
            }
            if (emojiCoolness >= threshold) {
                String fullEmoji = separator + separator + emojiText + separator + separator;
                emojiList.add(fullEmoji);

            }


        }
        System.out.printf("%d emojis found in the text. The cool ones are:%n", countOfEmoji);
        emojiList.stream().forEach(System.out::println);


    }
}
