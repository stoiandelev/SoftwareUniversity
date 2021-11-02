import java.util.Scanner;

public class GamingStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double currentBalance = Double.parseDouble(scanner.nextLine());
        String game = scanner.nextLine();
        double totalSpent = 0;
        int  flag=0;
        double price = 0;

        while (!game.equals("Game Time")) {
            switch (game) {
                case "OutFall 4":
                    price = 39.99;
                    if (price > currentBalance) {
                        System.out.println("Too Expensive");
                    } else {
                        System.out.println("Bought OutFall 4");

                        currentBalance -= price;
                        totalSpent += price;
                    }
                    break;
                case "CS: OG":
                    price = 15.99;
                    if (price > currentBalance) {
                        System.out.println("Too Expensive");
                    } else {
                        System.out.println("Bought CS: OG");

                        currentBalance -= price;
                        totalSpent += price;
                    }
                    break;
                case "Zplinter Zell":
                    price = 19.99;
                    if (price > currentBalance) {
                        System.out.println("Too Expensive");
                    } else {
                        System.out.println("Bought Zplinter Zell");

                        currentBalance -= price;
                        totalSpent += price;
                    }
                    break;
                case "Honored 2":
                    price = 59.99;
                    if (price > currentBalance) {
                        System.out.println("Too Expensive");
                    } else {
                        System.out.println("Bought Honored 2");

                        currentBalance -= price;
                        totalSpent += price;
                    }
                    break;
                case "RoverWatch":
                    price = 29.99;
                    if (price > currentBalance) {
                        System.out.println("Too Expensive");
                    } else {
                        System.out.println("Bought RoverWatch");

                        currentBalance -= price;
                        totalSpent += price;
                    }
                    break;
                case "RoverWatch Origins Edition":
                    price = 39.99;
                    if (price > currentBalance) {
                        System.out.println("Too Expensive");
                    } else {
                        System.out.println("Bought RoverWatch Origins Edition");

                        currentBalance -= price;
                        totalSpent += price;
                    }
                    break;
                default:
                    System.out.println("Not Found");
                    break;
            }

            if (currentBalance == 0) {
                flag=1;
                System.out.println("Out of money!");
                break;
            }
            game = scanner.nextLine();

        }

        if (flag==0) {
            System.out.printf("Total spent: $%.2f. Remaining: $%.2f", totalSpent, currentBalance);
        }


    }
}
