import java.text.DecimalFormat;
import java.util.Scanner;

public class MathPower {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double number=Double.parseDouble(scanner.nextLine());
        int numberPower=Integer.parseInt(scanner.nextLine());

        double mathPowerNumber=mathPowerNumber(number,numberPower);
        System.out.println(new DecimalFormat("0.####").format(mathPowerNumber(number,numberPower)));


    }

    private static double mathPowerNumber(double number, int numberPower) {
        double mathPower=Math.pow(number,numberPower);
        return mathPower;
    }
}
