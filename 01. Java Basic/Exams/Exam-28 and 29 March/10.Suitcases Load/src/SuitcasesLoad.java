import java.util.Scanner;

public class SuitcasesLoad {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double storage = Double.parseDouble(scanner.nextLine());
        String suitcase = scanner.nextLine();
        int count = 0;
        double currentSuitcase = 0;

        while (!suitcase.equals("End")) {
            currentSuitcase = Double.parseDouble(suitcase);
            if ((count + 1) % 3 == 0) {
                currentSuitcase *= 1.10;
            }
            if (currentSuitcase > storage) {
                break;
            }
            count++;
            storage -= currentSuitcase;
            suitcase = scanner.nextLine();

        }

        if (suitcase.equals("End")) {
            System.out.println("Congratulations! All suitcases are loaded!");
        } else {
            System.out.println("No more space!");
        }
        System.out.printf("Statistic: %d suitcases loaded.", count);


    }
}
