import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).
                mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());


        int divideNumber = Integer.parseInt(scanner.nextLine());

        //обратен ред
        Collections.reverse(numbers);

        //всички числа които се деля на divideNumber
        Predicate<Integer> checkDivision = number -> number % divideNumber == 0;

        numbers.removeIf(checkDivision);

        Consumer<List<Integer>> print = list -> list.forEach(e -> System.out.print(e + " "));

        print.accept(numbers);


    }
}
