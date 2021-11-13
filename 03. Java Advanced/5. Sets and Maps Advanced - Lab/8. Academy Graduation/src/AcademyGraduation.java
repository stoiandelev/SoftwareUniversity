import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AcademyGraduation {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int numberOfStudents = Integer.parseInt(scan.nextLine());
        Map<String, List<Double>> graduationList = new TreeMap<>();

        IntStream.range(0, numberOfStudents).mapToObj(i -> scan.nextLine())
                .forEach(name -> graduationList.put(name, Arrays.stream(scan.nextLine().split("\\s+"))
                        .map(Double::parseDouble).collect(Collectors.toList())));

        graduationList.forEach((k, v) -> System.out.printf("%s is graduated with %s%n", k, getAverage(v)));
    }

    private static Double getAverage(List<Double> value) {
        double average = 0.0;
        for (Double aDouble : value) {
            average += aDouble;
        }
        return average / value.size();
    }
}