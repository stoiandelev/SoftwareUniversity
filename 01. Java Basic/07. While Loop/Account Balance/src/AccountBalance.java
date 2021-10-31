import java.util.Scanner;

public class AccountBalance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String action = scanner.nextLine(); // number or text
        double balance = 0;

        while (!action.equals("NoMoreMoney")) {
            double deposit = Double.parseDouble(action);

            if(deposit < 0) {
                System.out.println("Invalid operation!");
                break;
            }else {
                balance += deposit;
                System.out.printf("Increase: %.2f\n", deposit);

            }
            action = scanner.nextLine();
        }

        System.out.printf("Total: %.2f", balance);








    }
}
