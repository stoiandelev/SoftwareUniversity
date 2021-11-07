import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String number = scanner.nextLine();
        String[] spitNumber = number.split(" ");

        ArrayDeque<String> stackNumberReverse = new ArrayDeque<>();
        Arrays.stream(spitNumber).forEach(stackNumberReverse::push);

        while (!stackNumberReverse.isEmpty()) {
            System.out.print(stackNumberReverse.pop() + " ");
        }

    }
}
