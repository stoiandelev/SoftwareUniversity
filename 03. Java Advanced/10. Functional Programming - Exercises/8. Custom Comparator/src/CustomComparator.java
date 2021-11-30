import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CustomComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        Comparator<Integer> comparator = (firstNumber, secondNumber) -> {
            if (firstNumber % 2 == 0 && secondNumber % 2 != 0) {
                return -1;//няма размяна
            } else if (firstNumber % 2 != 0 && secondNumber % 2 == 0) {
                return 1; //има размяна
            } else if ((firstNumber % 2 == 0 && secondNumber % 2 == 0) || (firstNumber % 2 != 0 && secondNumber % 2 != 0)) {
                if (firstNumber <= secondNumber) {
                    return -1; // няма размяна
                } else {
                    return 1; // има размяна
                }
            }
            return 0;
        };
        numbers.sort(comparator);
        numbers.forEach(e -> System.out.print(e + " "));


    }
}
