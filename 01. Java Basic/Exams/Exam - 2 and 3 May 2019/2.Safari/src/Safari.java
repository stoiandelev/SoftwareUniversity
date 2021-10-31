import java.util.Scanner;

public class Safari {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget=Double.parseDouble(scanner.nextLine());
        double fuel=Double.parseDouble(scanner.nextLine());
        String day=scanner.nextLine();

        double priceFuel=fuel*2.10;
        double priceFuelAndGuide=priceFuel+100;

        if(day.equals("Sunday")){
            priceFuelAndGuide=priceFuelAndGuide*0.80;
        }else{
            priceFuelAndGuide=priceFuelAndGuide*0.90;
        }

        if(budget>=priceFuelAndGuide){
            System.out.printf("Safari time! Money left: %.2f lv. ",budget-priceFuelAndGuide);
        }else{
            System.out.printf("Not enough money! Money needed: %.2f lv.",Math.abs(priceFuelAndGuide-budget));
        }












    }
}
