import java.util.Scanner;

public class Calculations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());

        switch (command) {
            case "add":
                add(a, b);
                break;
            case "multiply":
                multiply(a, b);
                break;
            case "subtract":
                subtract(a, b);
                break;
            case "divide":
                divide(a, b);
                break;
        }
    }

    private static void add(int a, int b) {
        int sum = a + b;
        System.out.println(sum);
    }

    private static void multiply(int a, int b) {
        int sum = a * b;
        System.out.println(sum);
    }

    private static void subtract(int a, int b) {
        int sum = a - b;
        System.out.println(sum);
    }

    private static void divide(int a, int b) {
        if (b == 0) {
            System.out.println("You do not divide on zero");
        } else {
            System.out.println(a / b);
        }


    }
}