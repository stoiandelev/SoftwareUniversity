import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Race {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> racers = Arrays.stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());

        String regexName = "[A-Za-z]+";
        String regexDistance = "[0-9]";
        Pattern patternName = Pattern.compile(regexName);
        Pattern patternDistance = Pattern.compile(regexDistance);

        Map<String, Integer> racersDistances = new LinkedHashMap<>();
        racers.forEach(race -> racersDistances.put(race, 0));


        String input = scanner.nextLine();
        while (!input.equals("end of race")) {

            Matcher matcherName = patternName.matcher(input);
            StringBuilder builderName = new StringBuilder();
            while (matcherName.find()) {
                builderName.append(matcherName.group());
            }
            String name = builderName.toString();


            int distance = 0;
            Matcher matcherDistance = patternDistance.matcher(input);
            while (matcherDistance.find()) {
                distance += Integer.parseInt(matcherDistance.group());
            }

            if (racersDistances.containsKey(name)) {
                racersDistances.put(name, racersDistances.get(name) + distance);
            }


            input = scanner.nextLine();
        }

        List<String> firstTree = racersDistances.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());


        System.out.println("1st place: " + firstTree.get(0));
        System.out.println("2nd place: " + firstTree.get(1));
        System.out.println("3rd place: " + firstTree.get(2));
    }
}
