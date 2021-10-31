import java.util.Scanner;

public class PoolDay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int people=Integer.parseInt(scanner.nextLine());
        double entryTaxes=Double.parseDouble(scanner.nextLine());
        double priceDeckChair=Double.parseDouble(scanner.nextLine());
        double priceUmbrella=Double.parseDouble(scanner.nextLine());

        double allEntryTaxes=people*entryTaxes;
        double allPriceDeckChair=(Math.ceil(people*0.75))*priceDeckChair;
        double allPriceUmbrella=(Math.ceil(people*0.50))*priceUmbrella;

        double totalPrice=allEntryTaxes+allPriceDeckChair+allPriceUmbrella;

        System.out.printf("%.2f lv.",totalPrice);
















    }
}
