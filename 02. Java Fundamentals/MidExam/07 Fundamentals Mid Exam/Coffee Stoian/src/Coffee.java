import java.util.Scanner;

public class Coffee {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countOfOrders = Integer.parseInt(scanner.nextLine());
        double priceForCapsule = 0.0;
        int days = 0;
        int capsuleCount = 0;
        double price = 0;
        double totalPrice = 0;


        for (int i = 1; i <=countOfOrders ; i++) {
            priceForCapsule=Double.parseDouble(scanner.nextLine());
            days=Integer.parseInt(scanner.nextLine());
            capsuleCount=Integer.parseInt(scanner.nextLine());

            price=(days*capsuleCount)*priceForCapsule;
            totalPrice+=price;
            System.out.printf("The price for the coffee is: $%.2f%n", price);

        }



        System.out.printf("Total: $%.2f", totalPrice);


    }
}
