import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class HeroesOfCodeAndLogicVII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfHeroes = Integer.parseInt(scanner.nextLine());

        Map<String, Integer> heroesHP = new TreeMap<>();
        Map<String, Integer> heroesMP = new TreeMap<>();

        for (int i = 0; i < numberOfHeroes; i++) {
            //{hero name} {HP} {MP}

            String[] command = scanner.nextLine().split("\\s+");

            String heroName = command[0];
            int heroHP = Integer.parseInt(command[1]);
            int heroMP = Integer.parseInt(command[2]);

            //a hero can have a maximum of 100 HP and 200 MP

            if (heroHP <= 100) {
                heroesHP.put(heroName, heroHP);
            }
            if (heroHP <= 200) {
                heroesMP.put(heroName, heroMP);
            }


        }
        String commands = scanner.nextLine();

        while (!commands.equals("End")) {

            String[] token = commands.split(" - ");
            String commandName = token[0];
            String heroName = token[1];

            switch (commandName) {

                case "CastSpell":
                    //{MP needed} – {spell name}
                    int neededMP = Integer.parseInt(token[2]);
                    String spellName = token[3];

                    int currentMP = heroesMP.get(heroName);
                    if (currentMP >= neededMP) {
                        int remainingMP = currentMP - neededMP;
                        System.out.printf("%s has successfully cast %s and now has %d MP!%n", heroName, spellName, remainingMP);
                        heroesMP.put(heroName, remainingMP);
                    } else {
                        System.out.printf("%s does not have enough MP to cast %s!%n", heroName, spellName);
                    }

                    break;
                case "TakeDamage":
                    //{hero name} – {damage} – {attacker}
                    int damageHP = Integer.parseInt(token[2]);
                    String attacker = token[3];

                    int currentDamage = heroesHP.get(heroName);
                    int remainingDamage = currentDamage - damageHP;
                    if (remainingDamage > 0) {
                        System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n", heroName, damageHP, attacker, remainingDamage);
                        heroesHP.put(heroName, remainingDamage);
                    } else {
                        System.out.printf("%s has been killed by %s!%n", heroName, attacker);
                        heroesHP.remove(heroName);
                        heroesMP.remove(heroName);
                    }


                    break;
                case "Recharge":
                    //{hero name} – {amount}
                    int amountMP = Integer.parseInt(token[2]);

                    int currentAmountMP = heroesMP.get(heroName);
                    int totalMP = currentAmountMP + amountMP;
                    if (totalMP > 200) {
                        totalMP = 200;
                    }
                    System.out.printf("%s recharged for %d MP!%n", heroName, totalMP - currentAmountMP);
                    heroesMP.put(heroName, totalMP);

                    break;
                case "Heal":
                    int amountHP = Integer.parseInt(token[2]);

                    int currentAmountHP = heroesHP.get(heroName);
                    int totalHP = currentAmountHP + amountHP;
                    if (totalHP > 100) {
                        totalHP = 100;
                    }
                    System.out.printf("%s healed for %d HP!%n", heroName, totalHP - currentAmountHP);
                    heroesHP.put(heroName, totalHP);


                    break;
            }
            commands = scanner.nextLine();


        }

        //HP in descending order

        heroesHP.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue(Comparator.reverseOrder()))// ->HP in descending order
                .forEach(hero -> {
                    System.out.println(hero.getKey());
                    System.out.println("  HP: " + hero.getValue());
                    System.out.println("  MP: " + heroesMP.get(hero.getKey()));
                });

        //mileageCar.entrySet().stream()
        //                .sorted(Map.Entry.<String, Integer>comparingByValue(Comparator.reverseOrder())// -> mileage in descending order
        //                .thenComparing(Map.Entry.comparingByKey())) // name is descending order
        //                .forEach(car -> {
        //                    System.out.println(car.getKey() + " -> Mileage: " + car.getValue() + " kms, Fuel in the tank: " +
        //                            fuelCar.get(car.getKey()) + " lt.");
        //
        //                });

        //heroesHP.entrySet().stream()
        //                .sorted((hero1, hero2) -> Integer.compare(hero2.getValue(), hero1.getValue()))// HP in descending order
        //                .forEach(hero -> {
        //                    System.out.println(hero.getKey());
        //                    System.out.println("  HP: " + hero.getValue());
        //                    System.out.println("  MP: " + heroesMP.get(hero.getKey()));
        //                });


    }
}
