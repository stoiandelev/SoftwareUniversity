import java.util.Scanner;

public class Travelling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String destination = scanner.nextLine();

        while (!destination.equals("End")) {
            double needMoney=Double.parseDouble(scanner.nextLine());
            double totalSaveMoney=0;
            while (totalSaveMoney<needMoney){
                double currentMoney=Double.parseDouble(scanner.nextLine());
                totalSaveMoney+=currentMoney;
            }

            System.out.printf("Going to %s!%n",destination);
            destination=scanner.nextLine();
        }
    

    }
}
