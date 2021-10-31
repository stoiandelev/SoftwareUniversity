import java.util.Scanner;

public class SummerOutfit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int degree = Integer.parseInt(scanner.nextLine());
        String time = scanner.nextLine();

        String outfit = "";
        String shoes = "";

        if (time.equals("Morning")) {
            if (degree >= 10 && degree <= 18) {
                outfit = "Sweatshirt";
                shoes = "Sneakers";
            } else if (degree > 18 && degree <= 24) {
                outfit = "Shirt";
                shoes = "Moccasins";
            } else {
                outfit="T-Shirt";
                shoes="Sandals";
            }
        }

        if (time.equals("Afternoon")) {
            if (degree >= 10 && degree <= 18) {
                outfit = "Shirt";
                shoes = "Moccasins";
            } else if (degree > 18 && degree <= 24) {
                outfit = "T-Shirt";
                shoes = "Sandals";
            } else {
                outfit="Swim Suit";
                shoes="Barefoot";
            }
        }

        if (time.equals("Evening")) {
            if (degree >= 10 && degree <= 18) {
                outfit = "Shirt";
                shoes = "Moccasins";
            } else if (degree > 18 && degree <= 24) {
                outfit = "Shirt";
                shoes = "Moccasins";
            } else {
                outfit="Shirt";
                shoes="Moccasins";
            }
        }
        System.out.println("It's "+ degree +" degrees, get your " +outfit+ " and "+shoes+".");





    }
}


























