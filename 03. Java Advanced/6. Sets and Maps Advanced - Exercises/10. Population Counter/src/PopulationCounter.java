import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class PopulationCounter {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Long> countries = new LinkedHashMap<>();
        Map<String, Map<String, Integer>> countriesCities = new HashMap<>();
        String input = reader.readLine();
        while (!input.equals("report")) {
            String[] data = input.split("\\|");
            String city = data[0];
            String country = data[1];
            int population = Integer.parseInt(data[2]);

            Long countryPop = countries.get(country);
            if (countryPop == null) {
                countries.put(country, (long) population);
                Map<String, Integer> cityPop = new LinkedHashMap<>();
                cityPop.put(city, population);
                countriesCities.put(country, cityPop);
            } else {
                countries.replace(country, countryPop + population);
                countriesCities.get(country).put(city, population);
            }

            input = reader.readLine();
        }
        reader.close();

        StringBuilder output = new StringBuilder();
        countries.entrySet()
                .stream()
                .sorted(reverseValueComparator())
                .forEach(p -> {
                    output.append(String.format("%s (total population: %d)", p.getKey(), p.getValue())).append(System.lineSeparator());
                    countriesCities.get(p.getKey()).entrySet()
                            .stream()
                            .sorted(reverseValueComparator())
                            .forEach(cp ->
                                    output.append(String.format("=>%s: %d", cp.getKey(), cp.getValue())).append(System.lineSeparator()));
                });
        System.out.print(output);
    }

    private static <T extends Comparable<T>> Comparator<Map.Entry<String, T>> reverseValueComparator() {
        return (p1, p2) -> p2.getValue().compareTo(p1.getValue());
    }
}