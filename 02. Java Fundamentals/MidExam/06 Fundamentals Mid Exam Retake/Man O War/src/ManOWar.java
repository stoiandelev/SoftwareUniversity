import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ManOWar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> pirateShip = Arrays.stream(scanner.nextLine().split(">"))
                .map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> warShip = Arrays.stream(scanner.nextLine().split(">"))
                .map(Integer::parseInt).collect(Collectors.toList());

        int maximumHealthCapacity = Integer.parseInt(scanner.nextLine());

        String commands = scanner.nextLine();

        while (!commands.equals("Retire")) {
            String[] splitCommand = commands.split("\\s+");
            String currentCommand = splitCommand[0];

            switch (currentCommand) {

                case "Fire":
                    int indexFire = Integer.parseInt(splitCommand[1]);
                    int damageFire = Integer.parseInt(splitCommand[2]);

                    if (indexFire < 0 || indexFire >= warShip.size()) {
                        break;
                    }

                    int sectionHealth = warShip.get(indexFire);
                    sectionHealth -= damageFire;

                    if (sectionHealth <= 0) {
                        System.out.println("You won! The enemy ship has sunken.");
                        return;
                    } else {
                        warShip.set(indexFire, sectionHealth);

                    }


                    break;
                case "Defend":

                    int startIndex = Integer.parseInt(splitCommand[1]);
                    int endIndex = Integer.parseInt(splitCommand[2]);
                    int damage = Integer.parseInt(splitCommand[3]);

                    if (startIndex < 0 || startIndex >= pirateShip.size()) {
                        break;
                    }

                    if (endIndex < 0 || endIndex >= pirateShip.size()) {
                        break;
                    }

                    for (int i = startIndex; i <= endIndex; i++) {
                        int currentSection = pirateShip.get(i);
                        currentSection -= damage;
                        if (currentSection <= 0) {
                            System.out.println("You lost! The pirate ship has sunken.");
                            return;
                        } else {
                            pirateShip.set(i, currentSection);
                        }
                    }

                    break;
                case "Repair":
                    int index = Integer.parseInt(splitCommand[1]);
                    int health = Integer.parseInt(splitCommand[2]);

                    if (index < 0 || index >= pirateShip.size()) {
                        break;
                    }

                    int repairSection = pirateShip.get(index);
                    repairSection += health;

                    if (repairSection > maximumHealthCapacity) {
                        repairSection = maximumHealthCapacity;
                    }
                    pirateShip.set(index, repairSection);


                    break;
                case "Status":
                    int count = 0;
                    for (Integer currentSection : pirateShip) {
                        if (currentSection < 0.2 * maximumHealthCapacity) {
                            count++;
                        }

                    }
                    System.out.printf("%d sections need repair.%n", count);
                    break;


            }


            commands = scanner.nextLine();
        }
        int pirateShipStatus = 0;
        for (Integer currentStatus : pirateShip) {
            pirateShipStatus += currentStatus;
        }

        int warShipStatus = 0;
        for (Integer currentStatus : warShip) {
            warShipStatus += currentStatus;
        }

        System.out.println("Pirate ship status: " + pirateShipStatus);
        System.out.println("Warship status: " + warShipStatus);


    }
}
