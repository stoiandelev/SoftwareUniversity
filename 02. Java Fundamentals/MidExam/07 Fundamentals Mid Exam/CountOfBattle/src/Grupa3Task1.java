import java.util.Scanner;

public class Grupa3Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double neededExperiense = Double.parseDouble(scanner.nextLine());
        int countOfBattle = Integer.parseInt(scanner.nextLine());


        double sum = 0.0;
        int count = 1;
        for (int i = 0; i < countOfBattle; i++) {
            double exPerBattle = Double.parseDouble(scanner.nextLine());
            if (count % 3 == 0) {
                exPerBattle = exPerBattle + (exPerBattle * 0.15);
            }
            if (count % 5 == 0) {
                exPerBattle = exPerBattle - (exPerBattle * 0.10);
            }
            if (count % 15 == 0) {
                exPerBattle = exPerBattle * 1.05;

            }
            sum += exPerBattle;

            if (sum >= neededExperiense) {
                break;
            }
            count++;
        }
        if (sum >= neededExperiense) {
            System.out.printf("Player successfully collected his needed experience for %d battles.", count);
        } else {
            System.out.printf("Player was not able to collect the needed experience, %.2f more needed.", neededExperiense - sum);
        }
    }
}