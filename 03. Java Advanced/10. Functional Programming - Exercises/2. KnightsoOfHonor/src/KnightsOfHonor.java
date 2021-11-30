import java.util.Scanner;
import java.util.function.Consumer;

public class KnightsOfHonor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] names = input.split("\\s+");

        Consumer<String[]> printString = array -> {
            for (String string : array) {
                System.out.println("Sir " + string);
            }
        };
        printString.accept(names);








    }
}
