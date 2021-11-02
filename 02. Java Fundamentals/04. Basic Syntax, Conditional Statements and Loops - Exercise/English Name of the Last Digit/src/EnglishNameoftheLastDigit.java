import java.util.Scanner;

public class EnglishNameoftheLastDigit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        int digitNumber = number % 10;

        if (digitNumber == 1) {
            System.out.println("one");
        } else if (digitNumber == 2) {
            System.out.println("two");
        } else if (digitNumber == 3) {
            System.out.println("three");
        } else if (digitNumber == 4) {
            System.out.println("four");
        } else if (digitNumber == 5) {
            System.out.println("five");
        } else if (digitNumber == 6) {
            System.out.println("six");
        } else if (digitNumber == 7) {
            System.out.println("seven");
        } else if (digitNumber == 8) {
            System.out.println("eight");
        } else if (digitNumber == 9) {
            System.out.println("nine");
        } else if (digitNumber == 0) {
            System.out.println("zero");
        }


    }
}
