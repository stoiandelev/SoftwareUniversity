import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> room = Arrays.stream(scanner.nextLine().split("\\|"))
                .collect(Collectors.toList());

        int health = 100;
        int bitcoin = 0;
        int bitcoinSum=0;
        boolean isAlive=true;

        for (int i = 0; i < room.size(); i++) {
            String roomIndex = room.get(i);
            String[] roomIndexSpit = roomIndex.split(" ");
            String firstIndex = roomIndexSpit[0];
            int secondIndex = Integer.parseInt(roomIndexSpit[1]);

            switch (firstIndex) {
                case "potion":
                    int currentHealth = health;
                    health = currentHealth + secondIndex;
                    if (health > 100) {
                        health = 100;
                    }
                    if (health < 100) {
                        System.out.printf("You healed for %d hp.%n", secondIndex);
                        System.out.printf("Current health: %d hp.%n", health);
                    } else if (health == 100) {
                        System.out.println("You healed for " + (100 - currentHealth) + " hp.");
                        System.out.printf("Current health: %d hp.%n", health);
                    }

                    break;
                case "chest":
                    bitcoin = secondIndex;
                    System.out.printf("You found %d bitcoins.%n", secondIndex);
                    bitcoinSum+=bitcoin;
                    break;
                default:
                    health = health - secondIndex;
                    if (health > 0) {
                        System.out.printf("You slayed %s.%n", firstIndex);
                    } else {
                        System.out.printf("You died! Killed by %s.%n", firstIndex);
                        System.out.printf("Best room: %d", i + 1);
                        isAlive=false;
                        return;
                    }



            }
        }
        if(isAlive){
            System.out.println("You've made it!");
            System.out.println("Bitcoins: "+bitcoinSum);
            System.out.println("Health: "+health);

        }


    }
}
