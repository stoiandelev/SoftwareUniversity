import java.util.Scanner;

public class FamilyTrip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget=Double.parseDouble(scanner.nextLine());
        int night=Integer.parseInt(scanner.nextLine());
        double priceNight=Double.parseDouble(scanner.nextLine());
        double extraCosts=Double.parseDouble(scanner.nextLine());

        if(night>7){
            priceNight=priceNight-(priceNight*0.05);
        }

        double totalNight=night*priceNight;
        double totalExtraCosts=(extraCosts/100)*budget;

        double totalNeedMoney=totalNight+totalExtraCosts;

        if(totalNeedMoney<=budget){
            System.out.printf("Ivanovi will be left with %.2f leva after vacation.",budget-totalNeedMoney);
        }else{
            System.out.printf("%.2f leva needed.",Math.abs(totalNeedMoney-budget));
        }










    }
}
