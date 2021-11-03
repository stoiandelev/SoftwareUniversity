import java.util.Scanner;

public class SpiceMustFlow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int startingYield = Integer.parseInt(scanner.nextLine());

        int crewConsummation = 26;
        int days = 0;
        int totalSpice = 0;

        if (startingYield >= 100) {
            while (startingYield >= 100) {
                totalSpice += startingYield - crewConsummation;
                startingYield -= 10;
                days++;
            }
            totalSpice -= 26;
        }
        System.out.println(days);
        System.out.println(totalSpice);

    }
}
