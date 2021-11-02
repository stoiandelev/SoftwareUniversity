import java.util.Scanner;

public class MultiplicationTable20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNumber = Integer.parseInt(scanner.nextLine());
        int secondNumber = Integer.parseInt(scanner.nextLine());

        do {
            System.out.printf("%d X %d = %d%n", firstNumber, secondNumber, firstNumber * secondNumber);
            secondNumber++;
        } while (secondNumber <= 10);

    }
}

