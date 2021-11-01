import java.util.Scanner;

public class BasketballEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int tax=Integer.parseInt(scanner.nextLine());

        double priceKecove=tax*0.60;
        double basketballTeam=priceKecove*0.80;
        double ball =basketballTeam/4;
        double accessors=ball/5;

        double totalPrice=tax+priceKecove+basketballTeam+ball+accessors;

        System.out.printf("%.2f",totalPrice);























    }
}
