import java.util.Scanner;

public class Repainting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int naylon=Integer.parseInt(scanner.nextLine());
        int paint=Integer.parseInt(scanner.nextLine());
        int thinner=Integer.parseInt(scanner.nextLine());
        int hours=Integer.parseInt(scanner.nextLine());

        double totalNaylon=(naylon+2)*1.50;
        double totalPaint=(paint*1.10)*14.50;
        double totalThinner=thinner*5;

        double totalCost=totalNaylon+totalPaint+totalThinner+0.40;
        double costPeople=(totalCost*0.30)*hours;

        double needMoney=totalCost+costPeople;

        System.out.printf("Total expenses: %.2f lv.",needMoney);













    }
}
