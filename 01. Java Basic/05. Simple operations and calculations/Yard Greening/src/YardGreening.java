import java.util.Scanner;

public class YardGreening {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        double squareMeters=Double.parseDouble(scanner.nextLine());
        double priceForMeters=7.61;

        double firstPrice=squareMeters*7.61;
        double discount=firstPrice*0.18;
        double finalPriceWithDiscount=firstPrice-discount;



        System.out.println("The final price is:"+" "+finalPriceWithDiscount+" lv.");
        System.out.println("The discount is:"+" "+discount+" lv.");




        }

    }

