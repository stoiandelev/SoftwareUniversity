import java.util.Scanner;

public class FactorialDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number1=Integer.parseInt(scanner.nextLine());
        int number2=Integer.parseInt(scanner.nextLine());

        double facturial1=facturialDevision(number1);
        double facturial2=facturialDevision(number2);

        double result=facturial1/facturial2;

        System.out.printf("%.2f",result);




    }

    private static double facturialDevision(int number) {
        double sumFactorial=1;

        for (int i =1; i <=number ; i++) {
            sumFactorial*=i;

        }
        return sumFactorial;
    }
}
