import java.util.Scanner;

public class EasterGuests {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int guess=Integer.parseInt(scanner.nextLine());
        int budget=Integer.parseInt(scanner.nextLine());

        double needKozunak=Math.ceil(1.0*guess/3);
        double needEggs=guess*2;

        double priceKozunak=needKozunak*4;
        double priceEggs=needEggs*0.45;

        double totalPrice=priceKozunak+priceEggs;

        if(totalPrice<=budget){
            System.out.printf("Lyubo bought %.0f Easter bread and %.0f eggs.%n",needKozunak,needEggs);
            System.out.printf("He has %.2f lv. left.",budget-totalPrice);
        }else{
            double needMoney=Math.abs(totalPrice-budget);
            System.out.println("Lyubo doesn't have enough money.");
            System.out.printf("He needs %.2f lv. more.",needMoney);
        }


















    }
}
