import java.util.*;

public class Problem3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        Map<String, Integer> nameHealth = new TreeMap<>();
        Map<String, Integer> nameEnergy = new TreeMap<>();

        while (!command.equals("Results")) {
            String[] spitCommand = command.split(":");
            String switchCommand = spitCommand[0];

            switch (switchCommand) {
                case "Add":
                    String name = spitCommand[1];
                    int health = Integer.parseInt(spitCommand[2]);
                    int energy = Integer.parseInt(spitCommand[3]);

                    if (!nameHealth.containsKey(name)) {
                        nameHealth.put(name, health);
                    } else {
                        int currentHealth = nameHealth.get(name);
                        int totalHealth = currentHealth + health;
                        nameHealth.put(name, totalHealth);
                    }

                    if (!nameEnergy.containsKey(name)) {
                        nameEnergy.put(name, energy);
                    } else {
                        int currentEnergy = nameEnergy.get(name);
                        int totalEnergy = currentEnergy + energy;
                        nameEnergy.put(name, totalEnergy);
                    }

                    break;
                case "Attack":
                    String attackerName = spitCommand[1];
                    String defenderName = spitCommand[2];
                    int damage = Integer.parseInt(spitCommand[3]);

                    if (nameEnergy.containsKey(attackerName) && nameEnergy.containsKey(defenderName)) {

                        int currentHealthDefender = nameHealth.get(defenderName);
                        int heathAfterDamage = currentHealthDefender - damage;

                        if (heathAfterDamage <= 0) {
                            System.out.printf("%s was disqualified!%n", defenderName);
                            nameEnergy.remove(defenderName);
                            nameHealth.remove(defenderName);
                        }else{
                            nameHealth.put(defenderName, heathAfterDamage);

                        }

                        int currentEnergyAttacker = nameEnergy.get(attackerName);
                        int energyAfterAttack = currentEnergyAttacker - 1;

                        if (energyAfterAttack <= 0) {
                            System.out.printf("%s was disqualified!%n", attackerName);
                            nameEnergy.remove(attackerName);
                            nameHealth.remove(attackerName);
                        }else{
                            nameEnergy.put(attackerName, energyAfterAttack);

                        }

                    }

                    break;
                case "Delete":
                    String username = spitCommand[1];

                    if(username.equals("All")){
                        nameEnergy.clear();
                        nameHealth.clear();
                        break;
                    }

                    if(nameEnergy.containsKey(username)){
                        nameEnergy.remove(username);
                        nameHealth.remove(username);
                    }




                    break;

            }


            command = scanner.nextLine();
        }
        System.out.printf("People count: %d%n",nameHealth.size());
        //Charlie - 4000 - 10
        //Allison - 2500 - 5


        //health and energy in descending order, name in ascending order
        nameHealth.entrySet().stream()
                .sorted((a, b) -> {
                    if (a.getValue() != b.getValue()) {
                        return Integer.compare(b.getValue(), a.getValue());
                    } else {
                        int aEnergy = nameEnergy.get(a.getKey());
                        int bEnergy = nameEnergy.get(b.getKey());

                        return Integer.compare(bEnergy, aEnergy);
                    }
                })
                .map(e -> String.format("%s - %d - %d", e.getKey(), nameHealth.get(e.getKey()), nameEnergy.get(e.getKey())))
                .forEach(System.out::println);
    }
}
