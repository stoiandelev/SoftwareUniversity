import java.util.*;

public class PlanDiscoveryStoyan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Integer> plants = new LinkedHashMap<>();
        Map<String, List<Double>> rating = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String command = scanner.nextLine();
            //Arnoldii<->4
            String[] commandSplit = command.split("<->");
            String plantsName = commandSplit[0];
            int rarity = Integer.parseInt(commandSplit[1]);

            plants.put(plantsName, rarity);
            rating.putIfAbsent(plantsName, new ArrayList<>());


        }
        String command = scanner.nextLine();
        while (!command.equals("Exhibition")) {
            String[] commandType = command.split(": ");

            String switchCommand = commandType[0];
            String plantsDatas = commandType[1];
            String[] plantSplitted = plantsDatas.split(" - ");

            String plantName = plantSplitted[0];

            if (!plants.containsKey(plantName)) {
                System.out.println("error");
                continue;
            }

            switch (switchCommand) {
                case "Rate":
                    //Rate: {plant} - {rating}
                    double currentRating = Integer.parseInt(plantSplitted[1]);
                    rating.get(plantName).add(currentRating);

                    break;
                case "Update":
                    //Update: {plant} - {new_rarity}
                    int newRarity = Integer.parseInt(plantSplitted[1]);
                    plants.put(plantName, newRarity);
                    break;
                case "Reset":
                    //Reset: {plant}
                    rating.get(plantName).clear();
                    break;
                default:
                    System.out.println("error");
            }


            command = scanner.nextLine();
        }
        System.out.println("Plants for the exhibition:");
        //The plants should be sorted by rarity descending, then by average rating descending
        //{plant_name}; Rarity: {rarity}; Rating: {average_rating formatted to the 2nd digit}

        plants.entrySet().stream()
                .sorted(Map.Entry.<String,Integer>comparingByValue()//rarity descending
                .thenComparingDouble(x -> rating.get(x.getKey()).stream()
                .mapToDouble(Double::doubleValue)
                .average().orElse(0.00))
                .reversed())//rating descending
                .forEach(e -> System.out.printf("- %s; Rarity: %d; Rating: %.2f%n",
                        e.getKey(),e.getValue(),rating.get(e.getKey())
                        .stream()
                        .mapToDouble(Double::doubleValue)
                        .average().orElse(0.00)));





    }
}
