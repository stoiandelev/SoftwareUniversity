import java.util.Scanner;

public class NewHouse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String flowersType = scanner.nextLine();
        int flowers = Integer.parseInt(scanner.nextLine());
        int budget = Integer.parseInt(scanner.nextLine());
        double price = 0;

        switch (flowersType) {
            case "Roses":
                price = 5;
                break;
            case "Dahlias":
                price = 3.80;
                break;
            case "Tulips":
                price = 2.80;
                break;
            case "Narcissus":
                price = 3;
                break;
            case "Gladiolus":
                price = 2.50;
                break;
        }

        double totalPrice = flowers * price;

        if (flowersType.equals("Roses") && flowers > 80) {
            totalPrice = totalPrice * 0.9;
        } else if (flowersType.equals("Dahlias") && flowers > 90) {
            totalPrice = totalPrice * 0.85;
        } else if (flowersType.equals("Tulips") && flowers > 80) {
            totalPrice = totalPrice * 0.85;
        } else if (flowersType.equals("Narcissus") && flowers < 120) {
            totalPrice = totalPrice * 1.15;
        } else if (flowersType.equals("Gladiolus") && flowers < 80) {
            totalPrice = totalPrice * 1.20;
        }

        double sumLeft = budget - totalPrice;
        double needMoney = totalPrice - budget;

        if (budget >= totalPrice) {
            System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.", flowers, flowersType, sumLeft);
        } else {
            System.out.printf("Not enough money, you need " + "%.2f", needMoney);
            System.out.print(" leva more.");
        }


    }
}
