
import java.util.Scanner;

public class OperationsBetweenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N1 = Integer.parseInt(scanner.nextLine());
        int N2 = Integer.parseInt(scanner.nextLine());
        String operator = scanner.nextLine();

        double calculate = 0;

        if ("+".equals(operator)){
            calculate = N1 + N2;
            if (calculate % 2 == 0){
                System.out.printf("%d %s %d = %.0f - even", N1, operator, N2, calculate);
            }else {
                System.out.printf("%d %s %d = %.0f - odd", N1, operator, N2, calculate);
            }
        }else if ("-".equals(operator)){
            calculate = N1 - N2;
            if (calculate % 2 == 0){
                System.out.printf("%d %s %d = %.0f - even", N1, operator, N2, calculate);
            }else {
                System.out.printf("%d %s %d = %.0f - odd",N1, operator, N2, calculate);
            }
        }else if ("*".equals(operator)){
            calculate = N1 * N2;
            if (calculate % 2 == 0){
                System.out.printf("%d %s %d = %.0f - even", N1, operator, N2, calculate);
            }else {
                System.out.printf("%d %s %d = %.0f - odd",N1, operator, N2, calculate);
            }
        }else if ("/".equals(operator)){
            calculate = N1*1.0 / N2;
            if (N2 == 0){
                System.out.printf("Cannot divide %d by zero",N1);
            }else {
                System.out.printf("%d %s %d = %.2f",N1,operator,N2,calculate);
            }
        }else if ("%".equals(operator)){
            calculate = N1*1.0 % N2;
            if (N2 == 0){
                System.out.printf("Cannot divide %d by zero", N1);
            }else {
                System.out.printf("%d %s %d = %.0f", N1, operator, N2, calculate);
            }
        }

    }
}