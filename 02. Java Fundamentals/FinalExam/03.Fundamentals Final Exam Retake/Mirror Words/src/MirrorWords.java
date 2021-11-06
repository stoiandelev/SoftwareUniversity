import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MirrorWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String regex = "([@#])([A-Za-z]{3,})\\1\\1([A-Za-z]{3,})\\1";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        List<String> mirrorWords = new ArrayList<>();

        int pairsCounter = 0;

        while (matcher.find()) {
            pairsCounter++;
            String firstWord = matcher.group(2);

            StringBuilder sb = new StringBuilder();
            for (int i = matcher.group(3).length() - 1; i >= 0; i--) {
                sb.append(matcher.group(3).charAt(i));
            }

            String secondWordReversed = sb.toString();

            if (firstWord.equals(secondWordReversed)) {
                StringBuilder sb1 = new StringBuilder(firstWord);
                sb.append(" <=> " + matcher.group(3));
                mirrorWords.add(sb.toString());
            }
        }


        if (pairsCounter == 0) {
            System.out.println("No word pairs found!");

        } else {
            System.out.println(pairsCounter + " word pairs found!");
        }
        if (mirrorWords.isEmpty()) {
            System.out.println("No mirror words!");
        } else {
            System.out.println("The mirror words are:");
            System.out.println(mirrorWords.toString().replaceAll("[\\[\\]]", ""));

        }

    }
}


