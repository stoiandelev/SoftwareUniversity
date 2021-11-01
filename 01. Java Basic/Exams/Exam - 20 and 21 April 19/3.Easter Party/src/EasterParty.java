import java.util.Scanner;

public class EasterParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int guess=Integer.parseInt(scanner.nextLine());
        double priceForOnePeople=Double.parseDouble(scanner.nextLine());
        double budget=Double.parseDouble(scanner.nextLine());

        if(guess>=10&&guess<=15){
            priceForOnePeople=priceForOnePeople*0.85;
        }else if(guess<=20&&guess>15){
            priceForOnePeople=priceForOnePeople*0.80;
        }else if(guess>20){
            priceForOnePeople=priceForOnePeople*0.75;
        }

        double priceCake=budget*0.10;

        double totalSum=guess*priceForOnePeople+priceCake;

        if(totalSum<=budget){
            System.out.printf("It is party time! %.2f leva left.",budget-totalSum);
        }else{
            System.out.printf("No party! %.2f leva needed.",Math.abs(totalSum-budget));
        }





















    }
}
