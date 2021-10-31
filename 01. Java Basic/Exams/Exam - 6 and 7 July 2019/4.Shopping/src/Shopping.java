import java.util.Scanner;

public class Shopping {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget=Double.parseDouble(scanner.nextLine());
        int videoCard=Integer.parseInt(scanner.nextLine());
        int processors=Integer.parseInt(scanner.nextLine());
        int ramMemory=Integer.parseInt(scanner.nextLine());

        double totalPriceVideoCard=videoCard*250;
        double priceProcessorsForOne=totalPriceVideoCard*0.35;
        double priceRamMemoryForOne=totalPriceVideoCard*0.10;

        double totalPriceProcessors=processors*priceProcessorsForOne;
        double totalPriceRamMemory=ramMemory*priceRamMemoryForOne;

        double allPrice=totalPriceVideoCard+totalPriceProcessors+totalPriceRamMemory;

        if(videoCard>processors){
            allPrice=allPrice-(allPrice*0.15);
        }

        if(allPrice<=budget){
            System.out.printf("You have %.2f leva left!",budget-allPrice);
        }else{
            System.out.printf("Not enough money! You need %.2f leva more!",Math.abs(allPrice-budget));
        }



















    }
}
