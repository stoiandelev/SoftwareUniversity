import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String drink = scanner.nextLine();
        String sugar = scanner.nextLine();
        int count = Integer.parseInt(scanner.nextLine());

        double price = 0;
        double totalPrice = 0;

        switch (drink) {
            case "Espresso":
                if (sugar.equals("Without")) {
                    price = 0.90;
                    totalPrice = count * price;
                    totalPrice=totalPrice*0.65;
                    if(count>=5){
                        totalPrice=totalPrice*0.75;
                    }
                } else if (sugar.equals("Normal")) {
                    price = 1.00;
                    totalPrice = count * price;
                    if(count>=5){
                        totalPrice=totalPrice*0.75;
                    }
                } else if (sugar.equals("Extra")) {
                    price = 1.20;
                    totalPrice = count * price;
                    if(count>=5){
                        totalPrice=totalPrice*0.75;
                    }
                }
                break;
            case "Cappuccino":
                if (sugar.equals("Without")) {
                    price = 1.00;
                    totalPrice=count*price;
                    totalPrice=totalPrice*0.65;
                } else if (sugar.equals("Normal")) {
                    price = 1.20;
                    totalPrice=count*price;
                } else if (sugar.equals("Extra")) {
                    price = 1.60;
                    totalPrice=count*price;
                }
                break;
            case "Tea":
                if (sugar.equals("Without")) {
                    price = 0.50;
                    totalPrice=count*price;
                    totalPrice=totalPrice*0.65;
                } else if (sugar.equals("Normal")) {
                    price = 0.60;
                    totalPrice=count*price;
                } else if (sugar.equals("Extra")) {
                    price = 0.70;
                    totalPrice=count*price;
                }
                break;
        }
        if(totalPrice>15){
            totalPrice=totalPrice*0.80;
        }

        System.out.printf("You bought %d cups of %s for %.2f lv.",count,drink,totalPrice);







    }
}
