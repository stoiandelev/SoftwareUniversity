import java.util.*;

public class PlantDiscovery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> plants = new LinkedHashMap<>();
        Map<String, List<Double>> rating = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String command = scanner.nextLine();
            String[] spitedCommand = command.split("<->");

            String plantName = spitedCommand[0];
            int rarity = Integer.parseInt(spitedCommand[1]);

            plants.compute(plantName, (k, v) -> rarity);
            rating.putIfAbsent(plantName, new ArrayList<>());

        }

        String command = scanner.nextLine();
        while (!command.equals("Exhibition")) {
            //Rate: Woodii - 10
            String[] spitedCommand = command.split(": ");
            String tokenForSwitch = spitedCommand[0];

            String[] element = spitedCommand[1].split(" - ");
            String name = element[0];

            if (!plants.containsKey(name)) {
                System.out.println("Error");
                continue;
            }

            switch (tokenForSwitch) {
                case "Rate":
                    double rate = Double.parseDouble(element[1]);
                    rating.get(name).add(rate);
                    break;
                case "Update":
                    int newRarity = Integer.parseInt(element[1]);
                    plants.compute(name, (k, v) -> newRarity);
                    break;
                case "Reset":
                    rating.get(name).clear();
                    break;
                default:
                    System.out.println("error");
            }


            command = scanner.nextLine();
        }
        System.out.println("Plants for the exhibition:");
        //The plants should be sorted by rarity descending, then by average rating descending



        plants.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue()
                        .thenComparingDouble(x -> rating.get(x.getKey()).stream()
                                .mapToDouble(Double::doubleValue)
                                .average().orElse(0.0))
                        .reversed())
                .forEach(e -> System.out.printf("- %s; Rarity: %d; Rating: %.2f%n", e.getKey(),
                        e.getValue(), rating.get(e.getKey()).stream().mapToDouble(Double::doubleValue).average().orElse(0.0)));


    }

}

