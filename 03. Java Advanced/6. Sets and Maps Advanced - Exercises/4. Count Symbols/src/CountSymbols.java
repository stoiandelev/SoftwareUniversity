import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        TreeMap<Character, Integer> symbols = new TreeMap<>();

        for (int i = 0; i < text.length(); i++) {
            char currentSymbol = text.charAt(i);

            if (!symbols.containsKey(currentSymbol)) {
                symbols.put(currentSymbol, 1);
            } else {
                Integer currentCount = symbols.get(currentSymbol);
                symbols.put(currentSymbol, currentCount + 1);
            }
        }
        symbols.forEach((key, value) -> System.out.println(key + ": " + value + " time/s"));
    }
}
