import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<Double, Integer> numbers = new LinkedHashMap<>();

        double[] values = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble).toArray();

        for (double value : values) {
            if (!numbers.containsKey(value)) {
                numbers.put(value, 1);
            } else {
                int currentValueOccurrences = numbers.get(value);
                numbers.put(value, currentValueOccurrences + 1);
            }
        }
        //5.5 -> 4
        numbers.forEach((key, value) -> System.out.printf("%.1f -> %d%n", key, value));


    }
}
