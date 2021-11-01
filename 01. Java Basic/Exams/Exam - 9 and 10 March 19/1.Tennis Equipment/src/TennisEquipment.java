import java.util.Scanner;

public class TennisEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double priceTennis=Double.parseDouble(scanner.nextLine());
        int countTennis=Integer.parseInt(scanner.nextLine());
        int maratonki=Integer.parseInt(scanner.nextLine());

        double totalPriceRaketi=priceTennis*countTennis;

        double priceMaratonki=priceTennis/6;

        double totalPriceMaratonki=priceMaratonki*maratonki;

        double priceOtherEquipment=(totalPriceRaketi+totalPriceMaratonki)*0.2;

        double totalPrice=totalPriceRaketi+totalPriceMaratonki+priceOtherEquipment;

        double priceForDjokovic=totalPrice/8;
        priceForDjokovic=Math.floor(priceForDjokovic);

        double priceForSponsor=(totalPrice*7)/8;
        priceForSponsor=Math.ceil(priceForSponsor);




        System.out.printf("Price to be paid by Djokovic %.0f%n",priceForDjokovic);
        System.out.printf("Price to be paid by sponsors %.0f",priceForSponsor);




















    }
}
