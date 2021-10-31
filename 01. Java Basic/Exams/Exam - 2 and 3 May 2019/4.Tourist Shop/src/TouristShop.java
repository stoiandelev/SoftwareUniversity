import java.util.Scanner;

public class TouristShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget=Double.parseDouble(scanner.nextLine());

        String command=scanner.nextLine();
        double sumProduct=0;
        int countProduct=0;
        double needPrice=0;

        while (!command.equals("Stop")){
            String product=command;
            double priceProduct=Double.parseDouble(scanner.nextLine());
            countProduct++;

            if(countProduct%3==0){
                priceProduct=priceProduct/2;
            }

            budget-=priceProduct;
            if(budget<0){
                break;
            }
            sumProduct+=priceProduct;

            command=scanner.nextLine();
        }
            if(budget>0){
                System.out.printf("You bought %d products for %.2f leva.",countProduct,sumProduct);
            }else{
                System.out.println("You don't have enough money!");
                System.out.printf("You need %.2f leva!",Math.abs(budget));
            }





























    }
}
