import java.util.*;
import java.util.stream.Collectors;

public class Problem3Other {
    static Map<String, Integer> personHealth = new HashMap<>();
    static Map<String, Integer> personEnergy = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command;
        while (!"Results".equals(command = scanner.nextLine())) {
            String[] commandParts = command.split(":");
            String commandType = commandParts[0];
            switch (commandType) {
                case "Add":
                    add(commandParts[1], Integer.parseInt(commandParts[2]), Integer.parseInt(commandParts[3]));
                    break;
                case "Attack":
                    attack(commandParts[1], commandParts[2], Integer.parseInt(commandParts[3]));
                    break;
                case "Delete":
                    delete(commandParts[1]);
                    break;
            }
        }
        List<String> names = personHealth.entrySet().stream()
                .sorted((entryA, entryB) -> {
                    int healthA = entryA.getValue();
                    String nameA = entryA.getKey();
                    int healthB = entryB.getValue();
                    String nameB = entryB.getKey();

                    if (healthA != healthB) {
                        return Integer.compare(healthB, healthA);
                    } else {
                        return nameA.compareTo(nameB);
                    }

                })
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.printf("People count: %d\n", names.size());
        for (String name : names) {
            System.out.printf("%s - %d - %d\n",
                    name, personHealth.get(name), personEnergy.get(name));
        }
    }

    private static void delete(String id) {
        if (id.equals("All")) {
            personHealth.clear();
            personEnergy.clear();
        } else {
            disqualify(id, false);
        }
    }

    private static void attack(String attacker, String defender, int damage) {
        Integer defenderHealth = personHealth.get(defender);
        Integer attackerEnergy = personEnergy.get(attacker);

        if (defenderHealth != null && attackerEnergy != null) {
            defenderHealth -= damage;
            if (defenderHealth <= 0) {
                disqualify(defender, true);
            } else {
                personHealth.put(defender, defenderHealth);
            }

            attackerEnergy--;
            if (attackerEnergy == 0) {
                disqualify(attacker, true);
            } else {
                personEnergy.put(attacker, attackerEnergy);
            }
        }
    }

    private static void disqualify(String id, boolean showMessage) {
        personHealth.remove(id);
        personEnergy.remove(id);
        if (showMessage) {
            System.out.printf("%s was disqualified!\n", id);
        }
    }

    private static void add(String name, int health, int energy) {
        Integer currentHealth = personHealth.get(name);
        if (currentHealth == null) {
            personHealth.put(name, health);
            personEnergy.put(name, energy);
        } else {
            personHealth.put(name, health + currentHealth);
        }

    }
}