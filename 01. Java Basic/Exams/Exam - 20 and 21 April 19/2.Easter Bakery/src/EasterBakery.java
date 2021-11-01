import java.util.Scanner;

public class EasterBakery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double priceBrashno=Double.parseDouble(scanner.nextLine());
        double kgBrashno=Double.parseDouble(scanner.nextLine());
        double kgSugar=Double.parseDouble(scanner.nextLine());
        int koriEggs=Integer.parseInt(scanner.nextLine());
        int maia=Integer.parseInt(scanner.nextLine());


        double priceSugar=priceBrashno*0.75;
        double priceEggs=priceBrashno*1.10;
        double priceMaia=priceSugar*0.2;

        double totalPriceBrashno=priceBrashno*kgBrashno;
        double totalPriceSugar=priceSugar*kgSugar;
        double totalPriceEgss=priceEggs*koriEggs;
        double totalPriceMaia=priceMaia*maia;

        double totalSum=totalPriceBrashno+totalPriceSugar+totalPriceEgss+totalPriceMaia;


        System.out.printf("%.2f",totalSum);













    }
}
