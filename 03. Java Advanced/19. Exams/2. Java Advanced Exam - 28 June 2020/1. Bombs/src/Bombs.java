import java.util.*;
import java.util.stream.Collectors;

public class Bombs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> bombEffect = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));

        int[] casings = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> bombCasings = new ArrayDeque<>();
        for (int e : casings) {
            bombCasings.push(e);
        }

        TreeMap<String, Integer> bombs = getMap();
        boolean isFilled = false;

        while (!bombEffect.isEmpty() && !bombCasings.isEmpty()) {
            int effect = bombEffect.poll();
            int casing = bombCasings.pop();
            int sum = effect + casing;

            switch (sum) {
                case 40:
                    bombs.put("Datura Bombs", bombs.get("Datura Bombs") + 1);
                    break;
                case 60:
                    bombs.put("Cherry Bombs", bombs.get("Cherry Bombs") + 1);
                    break;
                case 120:
                    bombs.put("Smoke Decoy Bombs", bombs.get("Smoke Decoy Bombs") + 1);
                    break;
                default:
                    bombCasings.push(casing - 5);
                    bombEffect.addFirst(effect);
                    break;
            }

            if (bombs.get("Datura Bombs") >= 3 && bombs.get("Cherry Bombs") >= 3
                    && bombs.get("Smoke Decoy Bombs") >= 3) {
                isFilled = true;
                break;
            }
        }

        StringBuilder output = new StringBuilder();
        if (isFilled) {
            output.append("Bene! You have successfully filled the bomb pouch!");
        } else {
            output.append("You don't have enough materials to fill the bomb pouch.");
        }
        output.append(System.lineSeparator());
        output.append(String.format("Bomb Effects: %s%n", getCollectionAsString(bombEffect)));
        output.append(String.format("Bomb Casings: %s%n", getCollectionAsString(bombCasings)));

        for (Map.Entry<String, Integer> entry : bombs.entrySet()) {
            output.append(entry.getKey()).append(": ").append(entry.getValue())
                    .append(System.lineSeparator());
        }

        System.out.println(output);

    }

    private static TreeMap<String, Integer> getMap() {
        TreeMap<String, Integer> bombs = new TreeMap<>();
        bombs.put("Datura Bombs", 0);
        bombs.put("Cherry Bombs", 0);
        bombs.put("Smoke Decoy Bombs", 0);
        return bombs;
    }

    public static String getCollectionAsString(ArrayDeque<Integer> collection) {
        return (String.join(", ",
                collection.isEmpty() ? "empty" :
                        String.valueOf(collection).replaceAll("[\\[\\]]", "")));
    }
}