import java.util.HashMap;
import java.util.Scanner;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<Integer, BankAccount> accountsMap = new HashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("End")) {

            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            //•	Create
            //•	Deposit {Id} {Amount}
            //•	SetInterest {Interest}
            //•	GetInterest {ID} {Years

            String output = null;

            if ("Create".equals(command)) {
                BankAccount bankAccount = new BankAccount();
                accountsMap.put(bankAccount.getId(), bankAccount);
                output = String.format("Account ID%d created", bankAccount.getId());

            } else if ("Deposit".equals(command)) {
                int id = Integer.parseInt(tokens[1]);
                int amount = Integer.parseInt(tokens[2]);
                BankAccount bankAccount = accountsMap.get(id);
                output = executeNotNull(bankAccount, b -> {
                    b.deposit(amount);
                    return String.format("Deposited %d to ID%d", amount, id);
                });
            } else if ("SetInterest".equals(command)) {
                BankAccount.setInterestRate(Double.parseDouble(tokens[1]));

            } else {
                int id = Integer.parseInt(tokens[1]);
                int years = Integer.parseInt(tokens[2]);
                BankAccount bankAccount = accountsMap.get(id);
                output = executeNotNull(bankAccount, b -> {
                    double interest = b.getInterest(years);
                    return String.format("%.2f", interest);
                });


            }
            if (output != null) {
                System.out.println(output);

            }

            input = scanner.nextLine();
        }


    }

    public static String executeNotNull(BankAccount account, Function<BankAccount, String> function) {
        if (account == null) {
            return "Account does not exist";
        }
        return function.apply(account);
    }
}
