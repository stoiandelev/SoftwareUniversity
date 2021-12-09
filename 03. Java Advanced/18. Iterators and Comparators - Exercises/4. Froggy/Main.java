package Froggy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] stones = Arrays.stream(scanner.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).toArray();
        Lake lake = new Lake(stones);

        Iterator<Integer> froggy = lake.iterator();
        List<String> stonesAfterFroggy = new ArrayList<>();

        while (froggy.hasNext()) {
            stonesAfterFroggy.add(froggy.next().toString());
        }

        System.out.println(String.join(", ", stonesAfterFroggy));
    }
}
