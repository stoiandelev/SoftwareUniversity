import java.util.Scanner;

public class ComputerStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        double totalPrice = 0.0;
        while (!input.equals("special") && !input.equals("regular")) {
            double price = Double.parseDouble(input);
            if (price < 0) {
                System.out.println("Invalid price!");
            }else {
                totalPrice += price;
            }

            input = scanner.nextLine();
        }

        double taxes = totalPrice * 0.2;
        double priceWithTaxes = totalPrice + taxes;

        if (totalPrice < 0) {
            System.out.println("Invalid order!");
        }

        if (input.equals("special")) {
            priceWithTaxes *= 0.9;
        } else if(input.equals("regular")){
            priceWithTaxes *= 1;
        }

        if(priceWithTaxes == 0) {
            System.out.println("Invalid order!");
        }else {
            System.out.println("Congratulations you've just bought a new computer!");
            System.out.printf("Price without taxes: %.2f$%n",totalPrice);
            System.out.printf("Taxes: %.2f$%n",taxes);
            System.out.println("-----------");
            System.out.printf("Total price: %.2f$",priceWithTaxes);
        }

    }
}