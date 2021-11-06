import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        int countOfPlayer = Integer.parseInt(scanner.nextLine());
        double groupEnergy = Double.parseDouble(scanner.nextLine());
        double waterPerDayForOnePerson = Double.parseDouble(scanner.nextLine());
        double foodPerDayForOnePerson = Double.parseDouble(scanner.nextLine());

        double totalWater = days * countOfPlayer * waterPerDayForOnePerson;
        double totalFood = days * countOfPlayer * foodPerDayForOnePerson;


        for (int i = 1; i <= days; i++) {

            double energyLoss = Double.parseDouble(scanner.nextLine());


            groupEnergy -= energyLoss;

            if (groupEnergy == 0 || groupEnergy < 0) {
                break;
            }

            if (i % 2 == 0) {
                groupEnergy = groupEnergy + (groupEnergy * 0.05);
                totalWater = totalWater - (totalWater * 0.30);

            }

            if (i % 3 == 0) {
                totalFood = totalFood - totalFood / countOfPlayer;
                groupEnergy += groupEnergy * 0.10;


            }


        }
        if (groupEnergy > 0) {
            System.out.printf("You are ready for the quest. You will be left with - %.2f energy!", groupEnergy);
        } else {
            System.out.printf("You will run out of energy. You will be left with %.2f food and %.2f water.",
                    totalFood, totalWater);

        }


    }
}
