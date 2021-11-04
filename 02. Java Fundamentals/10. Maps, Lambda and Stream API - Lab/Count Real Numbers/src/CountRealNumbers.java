import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        double[] nums = Arrays.stream(scanner.nextLine().split(" "))
                .mapToDouble(Double::parseDouble).toArray();

        Map<Double, Integer> numbers = new TreeMap<>();

        for (Double number : nums) {
            if (!numbers.containsKey(number)) {
                numbers.put(number, 1);
            } else {
                //броя на неговите срещания;
                int haves = numbers.get(number);
                haves++;
                numbers.put(number, haves);

            }

        }
        DecimalFormat decimalFormat = new DecimalFormat("#.#######");

        for (Map.Entry<Double, Integer> entry : numbers.entrySet()) {
            System.out.printf("%s -> %d%n", decimalFormat.format(entry.getKey()), entry.getValue());
        }


    }
}
