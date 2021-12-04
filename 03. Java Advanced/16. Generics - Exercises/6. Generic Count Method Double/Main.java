import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Box<Double> box = new Box<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
           double number = Double.parseDouble(scanner.nextLine());
            box.add(number);
        }

        double element = Double.parseDouble(scanner.nextLine());//елементът, който проверяваме колко по-големи има от него

        System.out.println(box.countGreaterThan(element));

    }
}
