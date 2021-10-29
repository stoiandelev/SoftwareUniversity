import java.util.Scanner;

public class EqualSumsEvenOddPosition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int startNumber = Integer.parseInt(scanner.nextLine());
        int endNumber = Integer.parseInt(scanner.nextLine());

        for (int number = startNumber; number <= endNumber; number++) {
            int units = number % 10;
            int tens = number / 10 % 10;
            int hundred = number / 100 % 10;
            int thousand = number / 1000 % 10;
            int desHil = number / 10000 % 10;
            int stoHil = number / 100000;

            int sumEven = units + hundred + desHil;
            int sumOdd = tens + thousand + stoHil;
            if (sumEven == sumOdd) {
                System.out.print(number + " ");
            }
        }


    }
}
