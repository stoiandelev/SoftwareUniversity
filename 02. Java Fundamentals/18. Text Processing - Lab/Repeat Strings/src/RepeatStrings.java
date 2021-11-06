import java.util.Scanner;

public class RepeatStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            int wordLength = word.length();

            for (int i = 0; i < wordLength; i++) {
                result.append(word);
            }
        }
        System.out.println(result);
    }
}
