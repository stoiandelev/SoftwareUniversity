import java.util.Scanner;

public class FoodDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int chickenMeals=Integer.parseInt(scanner.nextLine());
        int fishMeal=Integer.parseInt(scanner.nextLine());
        int vegetarianMeal=Integer.parseInt(scanner.nextLine());

        double delivery=2.50;

        double priceChickenMeal=10.35;
        double priceFishMeal=12.40;
        double priceVegetarianMeal=8.15;

        double allPriceChickenMeal=priceChickenMeal*chickenMeals;
        double allPriceFishMeal=priceFishMeal*fishMeal;
        double allPriceVegetarianMeal=priceVegetarianMeal*vegetarianMeal;

        double totalPrice=allPriceChickenMeal+allPriceFishMeal+allPriceVegetarianMeal;

        double dessert=totalPrice*0.20;

        double realPrice=totalPrice+dessert+delivery;

        System.out.printf("Total: %.2f",realPrice);























    }
}
