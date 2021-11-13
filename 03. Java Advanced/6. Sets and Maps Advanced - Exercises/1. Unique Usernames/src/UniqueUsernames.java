import java.util.LinkedHashSet;
import java.util.Scanner;

public class UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        LinkedHashSet<String> words = new LinkedHashSet<>();


        for (int i = 0; i < number; i++) {
            String word = scanner.nextLine();
            words.add(word);
        }

        for (String word : words) {
            System.out.println(word);

        }


    }
}
