import java.util.Scanner;

public class FishingBoat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Integer.parseInt(scanner.nextLine());
        String season = scanner.nextLine();
        int people = Integer.parseInt(scanner.nextLine());


        if (season.equals("Spring")) {
            double rentSpring = 3000;
            if (people <= 6) {
                rentSpring = rentSpring * 0.9;
            } else if (people > 7 && people <= 11) {
                rentSpring = rentSpring * 0.85;
            } else if (people >= 12) {
                rentSpring = rentSpring * 0.75;
            }

            if (people % 2 == 0) {
                rentSpring = rentSpring * 0.95;
            }
            double leftMoney = budget - rentSpring;
            double needMoney = Math.abs(budget - rentSpring);
            if (budget >= rentSpring) {
                System.out.printf("Yes! You have " + "%.2f",leftMoney);
                System.out.print(" leva left.");
            } else {
                System.out.printf("Not enough money! You need " + "%.2f",needMoney);
                System.out.print(" leva.");
            }
        }

        if (season.equals("Summer")) {
            double rentSummer = 4200;
            if (people <= 6) {
                rentSummer = rentSummer * 0.9;
            } else if (people > 7 && people <= 11) {
                rentSummer = rentSummer * 0.85;
            } else if (people >= 12) {
                rentSummer = rentSummer * 0.75;
            }

            if (people % 2 == 0) {
                rentSummer = rentSummer * 0.95;
            }
            double leftMoney = budget - rentSummer;
            double needMoney = Math.abs(budget - rentSummer);
            if (budget >= rentSummer) {
                System.out.printf("Yes! You have " + "%.2f",leftMoney);
                System.out.print(" leva left.");
            } else {
                System.out.printf("Not enough money! You need " + "%.2f",needMoney);
                System.out.print(" leva.");
            }
        }

        if (season.equals("Autumn")) {
            double rentAutumn = 4200;
            if (people <= 6) {
                rentAutumn = rentAutumn * 0.9;
            } else if (people > 7 && people <= 11) {
                rentAutumn = rentAutumn * 0.85;
            } else if (people >= 12) {
                rentAutumn = rentAutumn * 0.75;
            }

            double leftMoney = budget - rentAutumn;
            double needMoney = Math.abs(budget - rentAutumn);
            if (budget >= rentAutumn) {
                System.out.printf("Yes! You have " + "%.2f",leftMoney);
                System.out.print(" leva left.");
            } else {
                System.out.printf("Not enough money! You need " + "%.2f",needMoney);
                System.out.print(" leva.");
            }
        }

        if (season.equals("Winter")) {
            double rentWinter = 2600;
            if (people <= 6) {
                rentWinter = rentWinter * 0.9;
            } else if (people > 7 && people <= 11) {
                rentWinter = rentWinter * 0.85;
            } else if (people >= 12) {
                rentWinter = rentWinter * 0.75;
            }

            if (people % 2 == 0) {
                rentWinter = rentWinter * 0.95;
            }
            double leftMoney = budget - rentWinter;
            double needMoney = Math.abs(budget - rentWinter);
            if (budget >= rentWinter) {
                System.out.printf("Yes! You have " + "%.2f",leftMoney);
                System.out.print(" leva left.");
            } else {
                System.out.printf("Not enough money! You need " + "%.2f",needMoney);
                System.out.print(" leva.");
            }
        }


        


    }
}
