import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class PiratesStoyan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        Map<String, Integer> cityGold = new TreeMap<>();
        Map<String, Integer> cityPopulation = new TreeMap<>();

        while (!command.equals("Sail")) {
            String[] spitedCommand = command.split("\\|\\|");

            String cityName = spitedCommand[0];
            int population = Integer.parseInt(spitedCommand[1]);
            int gold = Integer.parseInt(spitedCommand[2]);

            if (!cityGold.containsKey(cityName)) {
                cityGold.put(cityName, gold);
            } else {
                int currentGold = cityGold.get(cityName);
                int totalGold = currentGold + gold;
                cityGold.put(cityName, totalGold);
            }

            if (!cityPopulation.containsKey(cityName)) {
                cityPopulation.put(cityName, population);
            } else {
                int currentPopulation = cityPopulation.get(cityName);
                int totalPopulation = currentPopulation + population;
                cityPopulation.put(cityName, totalPopulation);
            }


            command = scanner.nextLine();
        }

        String commandAction = scanner.nextLine();

        while (!commandAction.equals("End")) {
            String[] spitedCommandAction = commandAction.split("=>");

            String switchCommand = spitedCommandAction[0];
            String cityName = spitedCommandAction[1];

            switch (switchCommand) {
                case "Plunder":
                    //Plunder=>Tortuga=>75000=>380
                    int peopleKilled = Integer.parseInt(spitedCommandAction[2]);
                    int goldStolen = Integer.parseInt(spitedCommandAction[3]);


                    int peopleBeforePlunder = cityPopulation.get(cityName);
                    int goldBeforePlunder = cityGold.get(cityName);

                    int remainingPeople = peopleBeforePlunder - peopleKilled;
                    int remainingGold = goldBeforePlunder - goldStolen;


                    if (remainingGold <= 0 || remainingPeople <= 0) {
                        if (remainingGold <= 0) {
                            goldStolen = goldBeforePlunder;
                        }
                        if (remainingPeople <= 0) {
                            peopleKilled = peopleBeforePlunder;
                        }
                        System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", cityName, goldStolen, peopleKilled);
                        System.out.printf("%s has been wiped off the map!%n", cityName);

                        cityGold.remove(cityName);
                        cityPopulation.remove(cityName);

                        break;
                    }
                    System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", cityName, goldStolen, peopleKilled);
                    cityGold.put(cityName, remainingGold);
                    cityPopulation.put(cityName, remainingPeople);

                    break;
                case "Prosper":
                    //Prosper=>{town}=>{gold}
                    int goldToProsper = Integer.parseInt(spitedCommandAction[2]);

                    if (goldToProsper < 0) {
                        System.out.println("Gold added cannot be a negative number!");
                        break;
                    } else {
                        int currentGoldCity = cityGold.get(cityName);
                        int totalGoldCity = currentGoldCity + goldToProsper;
                        cityGold.put(cityName, totalGoldCity);
                        System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n",
                                goldToProsper, cityName, totalGoldCity);
                    }

                    break;
            }


            commandAction = scanner.nextLine();
        }
        System.out.printf("Ahoy, Captain! There are %s wealthy settlements to go to:%n", cityGold.size());

        //sorted by their gold in descending order, then by their name in ascending order
        //{town1} -> Population: {people} citizens, Gold: {gold} kg

        cityGold.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(p -> {
                    System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n",
                            p.getKey(), cityPopulation.get(p.getKey()), p.getValue());
                    ;
                });
    }
}
