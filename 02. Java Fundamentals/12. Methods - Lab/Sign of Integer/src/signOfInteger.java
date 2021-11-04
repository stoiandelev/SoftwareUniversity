import java.util.Scanner;

public class signOfInteger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number=Integer.parseInt(scanner.nextLine());

        printSign(number);
    }

    public static void printSign(int number) {
        if (number > 0) {
            System.out.printf("The number %d is positive.", number);
        } else if (number < 0) {
            System.out.printf("The number %d is negative.", number);
        } else {
            System.out.println("The number 0 is zero.");
        }
    }

}
