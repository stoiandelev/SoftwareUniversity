import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> words = new ArrayList<>();
        int count = 0;


        String[] input = scanner.nextLine().split("\\s+");

        for (String word : input) {
            if (Character.isUpperCase(word.charAt(0))) {
                words.add(word);
                count++;
            }
        }

        System.out.println(count);
        words.forEach(System.out::println);



    }
}
