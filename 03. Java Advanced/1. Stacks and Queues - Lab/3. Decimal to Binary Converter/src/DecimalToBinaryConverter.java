import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinaryConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int decimalNumber = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        if (decimalNumber == 0) {
            System.out.println(0);
        }

        while (decimalNumber != 0) {
            stack.push(decimalNumber % 2);
            decimalNumber /= 2;
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }

    }
}
