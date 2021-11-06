import java.util.Scanner;

public class BlackFlag {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        int dailyPlunder = Integer.parseInt(scanner.nextLine());
        double expectedPlunder = Integer.parseInt(scanner.nextLine());

        double plunderSum = 0;

        for (int i = 1; i <= days; i++) {
            plunderSum += dailyPlunder;

            if (i % 3 == 0) {
                plunderSum += dailyPlunder * 0.5;
            }

            if (i % 5 == 0) {
                plunderSum =plunderSum*0.7;
            }

        }


        if (plunderSum >= expectedPlunder) {
            System.out.printf("Ahoy! %.2f plunder gained.", plunderSum);
        } else {
            double percentLeft = plunderSum / expectedPlunder * 100;
            System.out.printf("Collected only %.2f%% of the plunder.", percentLeft);

        }


    }
}
