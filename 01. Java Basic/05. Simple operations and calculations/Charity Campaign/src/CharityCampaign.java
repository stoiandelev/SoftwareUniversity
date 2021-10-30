import java.util.Scanner;

public class CharityCampaign {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int totalDay=Integer.parseInt(scanner.nextLine());
        int cooker=Integer.parseInt(scanner.nextLine());
        int cake=Integer.parseInt(scanner.nextLine());
        int waffles =Integer.parseInt(scanner.nextLine());
        double pancake =Integer.parseInt(scanner.nextLine());

        double cakePrice=cake*45;
        double wafflesPrice=waffles*5.80;
        double pancakePrice=pancake*3.20;

        double totalSumOfCookers=(cakePrice+wafflesPrice+pancakePrice)*cooker;
        double totalSumOfAllCompany=totalSumOfCookers*totalDay;

        double ebitda=totalSumOfAllCompany-(totalSumOfAllCompany/8);

        System.out.printf("%.2f",ebitda);




    }
}
