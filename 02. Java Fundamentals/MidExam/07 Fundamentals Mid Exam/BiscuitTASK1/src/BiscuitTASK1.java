import java.util.Scanner;

public class BiscuitTASK1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int biscuitsPerDay = Integer.parseInt(scan.nextLine());
        int workerCount = Integer.parseInt(scan.nextLine());
        int competingFactoryBiscuits = Integer.parseInt(scan.nextLine());
        int totalBiscuits = 0;
        for (int i = 1; i <= 30; i++) {
            double production = biscuitsPerDay * workerCount;
            if (i % 3 == 0) {
                totalBiscuits += Math.floor(production * 0.75);
            } else {
                totalBiscuits += Math.floor(production);
            }
        }
        int diff;
        double percentageDiff;
        if (totalBiscuits >= competingFactoryBiscuits) {
            diff = totalBiscuits - competingFactoryBiscuits;
            percentageDiff = (double) diff / competingFactoryBiscuits * 100;
            System.out.printf("You have produced %d biscuits for the past month.\n", totalBiscuits);
            System.out.printf("You produce %.2f percent more biscuits.", percentageDiff);
        } else {
            diff = competingFactoryBiscuits - totalBiscuits;
            percentageDiff = (double) diff / competingFactoryBiscuits * 100;
            System.out.printf("You have produced %d biscuits for the past month.\n", totalBiscuits);
            System.out.printf("You produce %.2f percent less biscuits.", percentageDiff);
        }
    }
}