import java.util.Scanner;

public class FruitMarket {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        double berriesLeva=Double.parseDouble(scanner.nextLine());
        double bananaKg=Double.parseDouble(scanner.nextLine());
        double orangeKg=Double.parseDouble(scanner.nextLine());
        double raspberriesKg=Double.parseDouble(scanner.nextLine());
        double berrisKg=Double.parseDouble(scanner.nextLine());

        double raspberriesPrice=berriesLeva-berriesLeva*50/100;
        double orangePrice=raspberriesPrice-raspberriesPrice*40/100;
        double bananaPrice=raspberriesPrice-raspberriesPrice*80/100;

        double sumraspberries=raspberriesKg*raspberriesPrice;
        double sumberries=berrisKg*berriesLeva;
        double sumorange=orangeKg*orangePrice;
        double sumbananas=bananaKg*bananaPrice;

        double MoneyForBill=sumbananas+sumberries+sumorange+sumraspberries;

        System.out.printf("%.2f", MoneyForBill);


    }
}
