import java.util.Scanner;

public class SumOfChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numbersOfChar = Integer.parseInt(scanner.nextLine());
        int sum = 0;

        for (int i = 1; i <= numbersOfChar; i++) {
            char symbol = scanner.next().charAt(0);
            sum += (int) symbol;
        }
        System.out.printf("The sum equals: %d", sum);


    }
}
